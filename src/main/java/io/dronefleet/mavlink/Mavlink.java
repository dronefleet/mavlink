package io.dronefleet.mavlink;

import com.benbarkay.events.EventBus;
import com.benbarkay.events.EventEmitter;
import com.benbarkay.events.EventSource;
import io.dronefleet.mavlink.ardupilotmega.ArdupilotmegaVehicle;
import io.dronefleet.mavlink.common.*;
import io.dronefleet.mavlink.protocol.MavlinkPacketReader;
import io.dronefleet.mavlink.serialization.payload.reflection.ReflectionPayloadDeserializer;
import io.dronefleet.mavlink.serialization.payload.reflection.ReflectionPayloadSerializer;
import io.dronefleet.mavlink.util.DaemonThreadFactory;
import io.dronefleet.mavlink.util.EnumFlagSet;
import io.dronefleet.mavlink.vehicle.MavlinkVehicle;
import io.dronefleet.mavlink.vehicle.VehicleMessageDecorator;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class Mavlink {

    public static class Builder {
        private int systemId;
        private int heartbeatInterval;
        private TimeUnit heartbeatIntervalUnit;
        private Map<MavAutopilot, MavlinkDialect> dialects;
        private Executor executor;

        private Builder() {
            this.systemId = 255;
            this.dialects = new HashMap<>();
            this.heartbeatInterval = 1;
            this.heartbeatIntervalUnit = TimeUnit.SECONDS;
        }

        public Builder heartbeatInterval(int interval, TimeUnit unit) {
            this.heartbeatInterval = interval;
            this.heartbeatIntervalUnit = unit;
            return this;
        }

        public Builder systemId(int systemId) {
            this.systemId = systemId;
            return this;
        }

        public Builder dialect(MavAutopilot autopilot, MavlinkDialect dialect) {
            dialects.put(autopilot, dialect);
            return this;
        }

        public Mavlink startTcp(String ip, int port) throws IOException {
            Socket socket = new Socket(ip, port);
            return start(socket.getInputStream(), socket.getOutputStream());
        }

        public Mavlink start(InputStream in, OutputStream out) {
            ScheduledExecutorService eventQueue = Executors.newScheduledThreadPool(
                    1,
                    DaemonThreadFactory.defaultFactory());

            MavlinkConnection connection = new MavlinkConnection(
                    new MavlinkPacketReader(in),
                    out,
                    dialects,
                    new ReflectionPayloadDeserializer(),
                    new ReflectionPayloadSerializer(),
                    eventQueue);

            connection.disconnected().run(eventQueue::shutdown);
            (executor != null
                    ? executor
                    : Executors.newSingleThreadExecutor()
            ).execute(connection);

            eventQueue.scheduleAtFixedRate(() -> {
                connection.outgoing().emit(new MavlinkMessage<>(
                        systemId,
                        0,
                        Heartbeat.builder()
                                .autopilot(MavAutopilot.MAV_AUTOPILOT_INVALID)
                                .type(MavType.MAV_TYPE_GCS)
                                .systemStatus(MavState.MAV_STATE_UNINIT)
                                .mavlinkVersion(3)
                                .build()));
            }, 0, heartbeatInterval, heartbeatIntervalUnit);

            return new Mavlink(
                    systemId,
                    connection,
                    dialects,
                    eventQueue);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static void main(String args[]) throws IOException, InterruptedException {
        Mavlink mavlink = Mavlink.builder()
                .heartbeatInterval(1, TimeUnit.SECONDS)
                .systemId(240)
                .dialect(MavAutopilot.MAV_AUTOPILOT_ARDUPILOTMEGA, MavlinkDialects.ARDUPILOTMEGA)
                .startTcp("127.0.0.1", 5760);

        mavlink.vehicleConnected()
                .filter(ArdupilotmegaVehicle.class)
                .peek((vehicle) -> vehicle.sendRequestDataStream(
                        10,
                        vehicle.systemId(),
                        0,
                        6,
                        1))
                .consume((vehicle) -> vehicle.incoming()
                        .filter(GlobalPositionInt.class)
                        .consume(System.out::println));
    }

    private static class VehicleState {
        private final MavlinkVehicle vehicle;
        private final AtomicLong lastHeartbeat;

        private VehicleState(MavlinkVehicle vehicle, AtomicLong lastHeartbeat) {
            this.vehicle = vehicle;
            this.lastHeartbeat = lastHeartbeat;
        }
    }

    private final int systemId;
    private final MavlinkConnection connection;
    private final Map<MavAutopilot, MavlinkDialect> dialects;

    private final EventSource<MavlinkVehicle> vehicleConnected;
    private final EventSource<MavlinkVehicle> vehicleDisconnected;

    private final Map<Integer, VehicleState> connectedVehicles;

    public Mavlink(
            int systemId,
            MavlinkConnection connection,
            Map<MavAutopilot, MavlinkDialect> dialects,
            ScheduledExecutorService scheduledExecutorService) {
        this.systemId = systemId;
        this.connection = connection;
        this.dialects = dialects;
        connectedVehicles = new HashMap<>();

        EventSource<MavlinkMessage<Heartbeat>> heartbeats = connection.incoming()
                .filter((m) -> Heartbeat.class.isAssignableFrom(m.getPayload().getClass()))
                .filter(MavlinkMessage.ofGenericType(Heartbeat.class))
                .filter(m -> dialects.containsKey(m.getPayload().autopilot()));

        EventSource<MavlinkMessage<Heartbeat>> knownHeartbeats = heartbeats
                .filter(m -> connectedVehicles.containsKey(m.getOriginSystemId()));

        EventSource<MavlinkMessage<Heartbeat>> unknownHeartbeats = heartbeats
                .filter(m -> !connectedVehicles.containsKey(m.getOriginSystemId()));

        knownHeartbeats.map(MavlinkMessage::getOriginSystemId)
                .map(connectedVehicles::get)
                .consume(vehicleState -> vehicleState.lastHeartbeat.set(System.nanoTime()));

        vehicleConnected = unknownHeartbeats
                .map(this::newVehicle)
                .peek(s -> connectedVehicles.put(
                        s.systemId(),
                        new VehicleState(s, new AtomicLong(System.nanoTime()))));

        EventBus<MavlinkVehicle> vehicleDisconnectedBus = EventBus.create(connection.incoming().executor());
        vehicleDisconnected = vehicleDisconnectedBus;

        scheduledExecutorService.scheduleAtFixedRate(
                () -> connection.incoming().executor().execute(() ->
                        invalidateVehicles().stream()
                                .map(vs -> vs.vehicle)
                                .forEach(vehicleDisconnectedBus::emit)),
                5,
                5,
                TimeUnit.SECONDS);
    }

    public EventSource<MavlinkVehicle> vehicleConnected() {
        return vehicleConnected;
    }

    public EventSource<MavlinkVehicle> vehicleDisconnected() {
        return vehicleDisconnected;
    }

    private MavlinkVehicle newVehicle(MavlinkMessage<Heartbeat> heartbeatMessage) {
        Heartbeat heartbeat = heartbeatMessage.getPayload();
        MavlinkDialect dialect = dialects.get(heartbeat.autopilot());
        EventSource<?> incoming = connection.incoming()
                .filter((m) -> m.getOriginSystemId() == heartbeatMessage.getOriginSystemId())
                .map(MavlinkMessage::getPayload);
        EventEmitter<Object> outgoing = connection.outgoing()
                .demap(new VehicleMessageDecorator(systemId, dialect));

        //noinspection unchecked
        return dialect.newVehicle(
                heartbeatMessage.getOriginSystemId(),
                incoming,
                outgoing);
    }

    private List<VehicleState> invalidateVehicles() {
        long now = System.nanoTime();
        List<Integer> disconnectedVehicles = connectedVehicles.values().stream()
                .filter((vehicleState -> TimeUnit.SECONDS.convert(
                        now - vehicleState.lastHeartbeat.get(),
                        TimeUnit.NANOSECONDS) > 5))
                .map(vs -> vs.vehicle)
                .map(MavlinkVehicle::systemId)
                .collect(Collectors.toList());

        return disconnectedVehicles.stream()
                .map(connectedVehicles::remove)
                .collect(Collectors.toList());
    }
}
