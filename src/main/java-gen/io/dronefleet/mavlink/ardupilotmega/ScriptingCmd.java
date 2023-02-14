package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum ScriptingCmd {
    /**
     * Start a REPL session. 
     */
    @MavlinkEntryInfo(0)
    SCRIPTING_CMD_REPL_START,

    /**
     * End a REPL session. 
     */
    @MavlinkEntryInfo(1)
    SCRIPTING_CMD_REPL_STOP,

    /**
     * Stop execution of scripts. 
     */
    @MavlinkEntryInfo(2)
    SCRIPTING_CMD_STOP,

    /**
     * Stop execution of scripts and restart. 
     */
    @MavlinkEntryInfo(3)
    SCRIPTING_CMD_STOP_AND_RESTART
}
