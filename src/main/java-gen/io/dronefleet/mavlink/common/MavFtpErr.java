package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * MAV FTP error codes (https://mavlink.io/en/services/ftp.html) 
 */
@MavlinkEnum
public enum MavFtpErr {
    /**
     * None: No error 
     */
    @MavlinkEntryInfo(0)
    MAV_FTP_ERR_NONE,

    /**
     * Fail: Unknown failure 
     */
    @MavlinkEntryInfo(1)
    MAV_FTP_ERR_FAIL,

    /**
     * FailErrno: Command failed, Err number sent back in PayloadHeader.data[1]. This is a 
     * file-system error number understood by the server operating system. 
     */
    @MavlinkEntryInfo(2)
    MAV_FTP_ERR_FAILERRNO,

    /**
     * InvalidDataSize: Payload size is invalid 
     */
    @MavlinkEntryInfo(3)
    MAV_FTP_ERR_INVALIDDATASIZE,

    /**
     * InvalidSession: Session is not currently open 
     */
    @MavlinkEntryInfo(4)
    MAV_FTP_ERR_INVALIDSESSION,

    /**
     * NoSessionsAvailable: All available sessions are already in use 
     */
    @MavlinkEntryInfo(5)
    MAV_FTP_ERR_NOSESSIONSAVAILABLE,

    /**
     * EOF: Offset past end of file for ListDirectory and ReadFile commands 
     */
    @MavlinkEntryInfo(6)
    MAV_FTP_ERR_EOF,

    /**
     * UnknownCommand: Unknown command / opcode 
     */
    @MavlinkEntryInfo(7)
    MAV_FTP_ERR_UNKNOWNCOMMAND,

    /**
     * FileExists: File/directory already exists 
     */
    @MavlinkEntryInfo(8)
    MAV_FTP_ERR_FILEEXISTS,

    /**
     * FileProtected: File/directory is write protected 
     */
    @MavlinkEntryInfo(9)
    MAV_FTP_ERR_FILEPROTECTED,

    /**
     * FileNotFound: File/directory not found 
     */
    @MavlinkEntryInfo(10)
    MAV_FTP_ERR_FILENOTFOUND
}
