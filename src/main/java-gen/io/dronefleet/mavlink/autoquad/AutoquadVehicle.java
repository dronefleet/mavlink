package io.dronefleet.mavlink.autoquad;

import com.benbarkay.events.EventEmitter;
import com.benbarkay.events.EventSource;
import io.dronefleet.mavlink.common.CommonVehicle;
import io.dronefleet.mavlink.vehicle.AbstractMavlinkVehicle;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.util.List;

public interface AutoquadVehicle extends CommonVehicle {
    /**
     * Sends ESC32 telemetry data for up to 4 motors. Multiple messages may be sent in sequence when 
     * system has > 4 motors. Data is described as follows: // unsigned int state : 3; // unsigned int vin 
     * : 12; // x 100 // unsigned int amps : 14; // x 100 // unsigned int rpm : 15; // unsigned int duty : 8; // x 
     * (255/100) // - Data Version 2 - // unsigned int errors : 9; // Bad detects error count // - Data 
     * Version 3 - // unsigned int temp : 9; // (Deg C + 32) * 4 // unsigned int errCode : 3; 
     * @param timeBootMs Timestamp of the component clock since boot time in ms. 
     * @param data0 Data bits 1-32 for each ESC. 
     * @param data1 Data bits 33-64 for each ESC. 
     * @param statusAge Age of each ESC telemetry reading in ms compared to boot time. A value of 0xFFFF means timeout/no 
     * data. 
     * @param seq Sequence number of message (first set of 4 motors is #1, next 4 is #2, etc). 
     * @param numMotors Total number of active ESCs/motors on the system. 
     * @param numInSeq Number of active ESCs in this sequence (1 through this many array members will be populated with 
     * data) 
     * @param escid ESC/Motor ID 
     * @param dataVersion Version of data structure (determines contents). 
     */
    default void sendAqEscTelemetry(long timeBootMs, List<Long> data0, List<Long> data1,
            List<Integer> statusAge, int seq, int numMotors, int numInSeq, byte[] escid,
            byte[] dataVersion) {
        outgoing().emit(AqEscTelemetry.builder()
                .timeBootMs(timeBootMs)
                .data0(data0)
                .data1(data1)
                .statusAge(statusAge)
                .seq(seq)
                .numMotors(numMotors)
                .numInSeq(numInSeq)
                .escid(escid)
                .dataVersion(dataVersion)
                .build());
    }

    /**
     * Sends up to 20 raw float values. 
     * @param value1 value1 
     * @param value2 value2 
     * @param value3 value3 
     * @param value4 value4 
     * @param value5 value5 
     * @param value6 value6 
     * @param value7 value7 
     * @param value8 value8 
     * @param value9 value9 
     * @param value10 value10 
     * @param value11 value11 
     * @param value12 value12 
     * @param value13 value13 
     * @param value14 value14 
     * @param value15 value15 
     * @param value16 value16 
     * @param value17 value17 
     * @param value18 value18 
     * @param value19 value19 
     * @param value20 value20 
     * @param index Index of message 
     */
    default void sendAqTelemetryF(float value1, float value2, float value3, float value4,
            float value5, float value6, float value7, float value8, float value9, float value10,
            float value11, float value12, float value13, float value14, float value15,
            float value16, float value17, float value18, float value19, float value20, int index) {
        outgoing().emit(AqTelemetryF.builder()
                .value1(value1)
                .value2(value2)
                .value3(value3)
                .value4(value4)
                .value5(value5)
                .value6(value6)
                .value7(value7)
                .value8(value8)
                .value9(value9)
                .value10(value10)
                .value11(value11)
                .value12(value12)
                .value13(value13)
                .value14(value14)
                .value15(value15)
                .value16(value16)
                .value17(value17)
                .value18(value18)
                .value19(value19)
                .value20(value20)
                .index(index)
                .build());
    }

    final class Impl extends AbstractMavlinkVehicle implements AutoquadVehicle {
        Impl(int systemId, EventSource<Object> incoming, EventEmitter<Object> outgoing) {
            super(systemId, incoming, outgoing);
        }
    }
}
