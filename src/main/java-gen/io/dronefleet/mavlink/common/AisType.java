package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Type of AIS vessel, enum duplicated from AIS standard, 
 * https://gpsd.gitlab.io/gpsd/AIVDM.html 
 */
@MavlinkEnum
public enum AisType {
    /**
     * Not available (default). 
     */
    @MavlinkEntryInfo(0)
    AIS_TYPE_UNKNOWN,

    /**
     *  
     */
    @MavlinkEntryInfo(1)
    AIS_TYPE_RESERVED_1,

    /**
     *  
     */
    @MavlinkEntryInfo(2)
    AIS_TYPE_RESERVED_2,

    /**
     *  
     */
    @MavlinkEntryInfo(3)
    AIS_TYPE_RESERVED_3,

    /**
     *  
     */
    @MavlinkEntryInfo(4)
    AIS_TYPE_RESERVED_4,

    /**
     *  
     */
    @MavlinkEntryInfo(5)
    AIS_TYPE_RESERVED_5,

    /**
     *  
     */
    @MavlinkEntryInfo(6)
    AIS_TYPE_RESERVED_6,

    /**
     *  
     */
    @MavlinkEntryInfo(7)
    AIS_TYPE_RESERVED_7,

    /**
     *  
     */
    @MavlinkEntryInfo(8)
    AIS_TYPE_RESERVED_8,

    /**
     *  
     */
    @MavlinkEntryInfo(9)
    AIS_TYPE_RESERVED_9,

    /**
     *  
     */
    @MavlinkEntryInfo(10)
    AIS_TYPE_RESERVED_10,

    /**
     *  
     */
    @MavlinkEntryInfo(11)
    AIS_TYPE_RESERVED_11,

    /**
     *  
     */
    @MavlinkEntryInfo(12)
    AIS_TYPE_RESERVED_12,

    /**
     *  
     */
    @MavlinkEntryInfo(13)
    AIS_TYPE_RESERVED_13,

    /**
     *  
     */
    @MavlinkEntryInfo(14)
    AIS_TYPE_RESERVED_14,

    /**
     *  
     */
    @MavlinkEntryInfo(15)
    AIS_TYPE_RESERVED_15,

    /**
     *  
     */
    @MavlinkEntryInfo(16)
    AIS_TYPE_RESERVED_16,

    /**
     *  
     */
    @MavlinkEntryInfo(17)
    AIS_TYPE_RESERVED_17,

    /**
     *  
     */
    @MavlinkEntryInfo(18)
    AIS_TYPE_RESERVED_18,

    /**
     *  
     */
    @MavlinkEntryInfo(19)
    AIS_TYPE_RESERVED_19,

    /**
     * Wing In Ground effect. 
     */
    @MavlinkEntryInfo(20)
    AIS_TYPE_WIG,

    /**
     *  
     */
    @MavlinkEntryInfo(21)
    AIS_TYPE_WIG_HAZARDOUS_A,

    /**
     *  
     */
    @MavlinkEntryInfo(22)
    AIS_TYPE_WIG_HAZARDOUS_B,

    /**
     *  
     */
    @MavlinkEntryInfo(23)
    AIS_TYPE_WIG_HAZARDOUS_C,

    /**
     *  
     */
    @MavlinkEntryInfo(24)
    AIS_TYPE_WIG_HAZARDOUS_D,

    /**
     *  
     */
    @MavlinkEntryInfo(25)
    AIS_TYPE_WIG_RESERVED_1,

    /**
     *  
     */
    @MavlinkEntryInfo(26)
    AIS_TYPE_WIG_RESERVED_2,

    /**
     *  
     */
    @MavlinkEntryInfo(27)
    AIS_TYPE_WIG_RESERVED_3,

    /**
     *  
     */
    @MavlinkEntryInfo(28)
    AIS_TYPE_WIG_RESERVED_4,

    /**
     *  
     */
    @MavlinkEntryInfo(29)
    AIS_TYPE_WIG_RESERVED_5,

    /**
     *  
     */
    @MavlinkEntryInfo(30)
    AIS_TYPE_FISHING,

    /**
     *  
     */
    @MavlinkEntryInfo(31)
    AIS_TYPE_TOWING,

    /**
     * Towing: length exceeds 200m or breadth exceeds 25m. 
     */
    @MavlinkEntryInfo(32)
    AIS_TYPE_TOWING_LARGE,

    /**
     * Dredging or other underwater ops. 
     */
    @MavlinkEntryInfo(33)
    AIS_TYPE_DREDGING,

    /**
     *  
     */
    @MavlinkEntryInfo(34)
    AIS_TYPE_DIVING,

    /**
     *  
     */
    @MavlinkEntryInfo(35)
    AIS_TYPE_MILITARY,

    /**
     *  
     */
    @MavlinkEntryInfo(36)
    AIS_TYPE_SAILING,

    /**
     *  
     */
    @MavlinkEntryInfo(37)
    AIS_TYPE_PLEASURE,

    /**
     *  
     */
    @MavlinkEntryInfo(38)
    AIS_TYPE_RESERVED_20,

    /**
     *  
     */
    @MavlinkEntryInfo(39)
    AIS_TYPE_RESERVED_21,

    /**
     * High Speed Craft. 
     */
    @MavlinkEntryInfo(40)
    AIS_TYPE_HSC,

    /**
     *  
     */
    @MavlinkEntryInfo(41)
    AIS_TYPE_HSC_HAZARDOUS_A,

    /**
     *  
     */
    @MavlinkEntryInfo(42)
    AIS_TYPE_HSC_HAZARDOUS_B,

    /**
     *  
     */
    @MavlinkEntryInfo(43)
    AIS_TYPE_HSC_HAZARDOUS_C,

    /**
     *  
     */
    @MavlinkEntryInfo(44)
    AIS_TYPE_HSC_HAZARDOUS_D,

    /**
     *  
     */
    @MavlinkEntryInfo(45)
    AIS_TYPE_HSC_RESERVED_1,

    /**
     *  
     */
    @MavlinkEntryInfo(46)
    AIS_TYPE_HSC_RESERVED_2,

    /**
     *  
     */
    @MavlinkEntryInfo(47)
    AIS_TYPE_HSC_RESERVED_3,

    /**
     *  
     */
    @MavlinkEntryInfo(48)
    AIS_TYPE_HSC_RESERVED_4,

    /**
     *  
     */
    @MavlinkEntryInfo(49)
    AIS_TYPE_HSC_UNKNOWN,

    /**
     *  
     */
    @MavlinkEntryInfo(50)
    AIS_TYPE_PILOT,

    /**
     * Search And Rescue vessel. 
     */
    @MavlinkEntryInfo(51)
    AIS_TYPE_SAR,

    /**
     *  
     */
    @MavlinkEntryInfo(52)
    AIS_TYPE_TUG,

    /**
     *  
     */
    @MavlinkEntryInfo(53)
    AIS_TYPE_PORT_TENDER,

    /**
     * Anti-pollution equipment. 
     */
    @MavlinkEntryInfo(54)
    AIS_TYPE_ANTI_POLLUTION,

    /**
     *  
     */
    @MavlinkEntryInfo(55)
    AIS_TYPE_LAW_ENFORCEMENT,

    /**
     *  
     */
    @MavlinkEntryInfo(56)
    AIS_TYPE_SPARE_LOCAL_1,

    /**
     *  
     */
    @MavlinkEntryInfo(57)
    AIS_TYPE_SPARE_LOCAL_2,

    /**
     *  
     */
    @MavlinkEntryInfo(58)
    AIS_TYPE_MEDICAL_TRANSPORT,

    /**
     * Noncombatant ship according to RR Resolution No. 18. 
     */
    @MavlinkEntryInfo(59)
    AIS_TYPE_NONECOMBATANT,

    /**
     *  
     */
    @MavlinkEntryInfo(60)
    AIS_TYPE_PASSENGER,

    /**
     *  
     */
    @MavlinkEntryInfo(61)
    AIS_TYPE_PASSENGER_HAZARDOUS_A,

    /**
     *  
     */
    @MavlinkEntryInfo(62)
    AIS_TYPE_PASSENGER_HAZARDOUS_B,

    /**
     *  
     */
    @MavlinkEntryInfo(63)
    AIS_TYPE_AIS_TYPE_PASSENGER_HAZARDOUS_C,

    /**
     *  
     */
    @MavlinkEntryInfo(64)
    AIS_TYPE_PASSENGER_HAZARDOUS_D,

    /**
     *  
     */
    @MavlinkEntryInfo(65)
    AIS_TYPE_PASSENGER_RESERVED_1,

    /**
     *  
     */
    @MavlinkEntryInfo(66)
    AIS_TYPE_PASSENGER_RESERVED_2,

    /**
     *  
     */
    @MavlinkEntryInfo(67)
    AIS_TYPE_PASSENGER_RESERVED_3,

    /**
     *  
     */
    @MavlinkEntryInfo(68)
    AIS_TYPE_AIS_TYPE_PASSENGER_RESERVED_4,

    /**
     *  
     */
    @MavlinkEntryInfo(69)
    AIS_TYPE_PASSENGER_UNKNOWN,

    /**
     *  
     */
    @MavlinkEntryInfo(70)
    AIS_TYPE_CARGO,

    /**
     *  
     */
    @MavlinkEntryInfo(71)
    AIS_TYPE_CARGO_HAZARDOUS_A,

    /**
     *  
     */
    @MavlinkEntryInfo(72)
    AIS_TYPE_CARGO_HAZARDOUS_B,

    /**
     *  
     */
    @MavlinkEntryInfo(73)
    AIS_TYPE_CARGO_HAZARDOUS_C,

    /**
     *  
     */
    @MavlinkEntryInfo(74)
    AIS_TYPE_CARGO_HAZARDOUS_D,

    /**
     *  
     */
    @MavlinkEntryInfo(75)
    AIS_TYPE_CARGO_RESERVED_1,

    /**
     *  
     */
    @MavlinkEntryInfo(76)
    AIS_TYPE_CARGO_RESERVED_2,

    /**
     *  
     */
    @MavlinkEntryInfo(77)
    AIS_TYPE_CARGO_RESERVED_3,

    /**
     *  
     */
    @MavlinkEntryInfo(78)
    AIS_TYPE_CARGO_RESERVED_4,

    /**
     *  
     */
    @MavlinkEntryInfo(79)
    AIS_TYPE_CARGO_UNKNOWN,

    /**
     *  
     */
    @MavlinkEntryInfo(80)
    AIS_TYPE_TANKER,

    /**
     *  
     */
    @MavlinkEntryInfo(81)
    AIS_TYPE_TANKER_HAZARDOUS_A,

    /**
     *  
     */
    @MavlinkEntryInfo(82)
    AIS_TYPE_TANKER_HAZARDOUS_B,

    /**
     *  
     */
    @MavlinkEntryInfo(83)
    AIS_TYPE_TANKER_HAZARDOUS_C,

    /**
     *  
     */
    @MavlinkEntryInfo(84)
    AIS_TYPE_TANKER_HAZARDOUS_D,

    /**
     *  
     */
    @MavlinkEntryInfo(85)
    AIS_TYPE_TANKER_RESERVED_1,

    /**
     *  
     */
    @MavlinkEntryInfo(86)
    AIS_TYPE_TANKER_RESERVED_2,

    /**
     *  
     */
    @MavlinkEntryInfo(87)
    AIS_TYPE_TANKER_RESERVED_3,

    /**
     *  
     */
    @MavlinkEntryInfo(88)
    AIS_TYPE_TANKER_RESERVED_4,

    /**
     *  
     */
    @MavlinkEntryInfo(89)
    AIS_TYPE_TANKER_UNKNOWN,

    /**
     *  
     */
    @MavlinkEntryInfo(90)
    AIS_TYPE_OTHER,

    /**
     *  
     */
    @MavlinkEntryInfo(91)
    AIS_TYPE_OTHER_HAZARDOUS_A,

    /**
     *  
     */
    @MavlinkEntryInfo(92)
    AIS_TYPE_OTHER_HAZARDOUS_B,

    /**
     *  
     */
    @MavlinkEntryInfo(93)
    AIS_TYPE_OTHER_HAZARDOUS_C,

    /**
     *  
     */
    @MavlinkEntryInfo(94)
    AIS_TYPE_OTHER_HAZARDOUS_D,

    /**
     *  
     */
    @MavlinkEntryInfo(95)
    AIS_TYPE_OTHER_RESERVED_1,

    /**
     *  
     */
    @MavlinkEntryInfo(96)
    AIS_TYPE_OTHER_RESERVED_2,

    /**
     *  
     */
    @MavlinkEntryInfo(97)
    AIS_TYPE_OTHER_RESERVED_3,

    /**
     *  
     */
    @MavlinkEntryInfo(98)
    AIS_TYPE_OTHER_RESERVED_4,

    /**
     *  
     */
    @MavlinkEntryInfo(99)
    AIS_TYPE_OTHER_UNKNOWN
}
