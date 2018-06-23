package io.dronefleet.mavlink.paparazzi;

import com.benbarkay.events.EventEmitter;
import com.benbarkay.events.EventSource;
import io.dronefleet.mavlink.common.CommonVehicle;
import io.dronefleet.mavlink.vehicle.AbstractMavlinkVehicle;
import java.lang.Object;
import java.lang.String;

public interface PaparazziVehicle extends CommonVehicle {
    /**
     * Message encoding a mission script item. This message is emitted upon a request for the next 
     * script item. 
     * @param seq Sequence 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param name The name of the mission script, NULL terminated. 
     */
    default void sendScriptItem(int seq, int targetSystem, int targetComponent, String name) {
        outgoing().emit(ScriptItem.builder()
                .seq(seq)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .name(name)
                .build());
    }

    /**
     * Request the overall list of mission items from the system/component. 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     */
    default void sendScriptRequestList(int targetSystem, int targetComponent) {
        outgoing().emit(ScriptRequestList.builder()
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .build());
    }

    /**
     * This message is emitted as response to {@link io.dronefleet.mavlink.paparazzi.ScriptRequestList ScriptRequestList} by the MAV to get the number of 
     * mission scripts. 
     * @param count Number of script items in the sequence 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     */
    default void sendScriptCount(int count, int targetSystem, int targetComponent) {
        outgoing().emit(ScriptCount.builder()
                .count(count)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .build());
    }

    /**
     * Request script item with the sequence number seq. The response of the system to this message 
     * should be a {@link io.dronefleet.mavlink.paparazzi.ScriptItem ScriptItem} message. 
     * @param seq Sequence 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     */
    default void sendScriptRequest(int seq, int targetSystem, int targetComponent) {
        outgoing().emit(ScriptRequest.builder()
                .seq(seq)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .build());
    }

    /**
     * This message informs about the currently active SCRIPT. 
     * @param seq Active Sequence 
     */
    default void sendScriptCurrent(int seq) {
        outgoing().emit(ScriptCurrent.builder()
                .seq(seq)
                .build());
    }

    final class Impl extends AbstractMavlinkVehicle implements PaparazziVehicle {
        Impl(int systemId, EventSource<Object> incoming, EventEmitter<Object> outgoing) {
            super(systemId, incoming, outgoing);
        }
    }
}
