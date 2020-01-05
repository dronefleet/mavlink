package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Tune formats (used for vehicle buzzer/tone generation). 
 */
@MavlinkEnum
public enum TuneFormat {
    /**
     * Format is QBasic 1.1 Play: 
     * https://www.qbasic.net/en/reference/qb11/Statement/PLAY-006.htm. 
     */
    @MavlinkEntryInfo(1)
    TUNE_FORMAT_QBASIC1_1,

    /**
     * Format is Modern Music Markup Language (MML): 
     * https://en.wikipedia.org/wiki/Music_Macro_Language#Modern_MML. 
     */
    @MavlinkEntryInfo(2)
    TUNE_FORMAT_MML_MODERN
}
