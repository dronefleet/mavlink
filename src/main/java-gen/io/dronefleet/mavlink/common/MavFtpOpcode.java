package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * MAV FTP opcodes: https://mavlink.io/en/services/ftp.html 
 */
@MavlinkEnum
public enum MavFtpOpcode {
    /**
     * None. Ignored, always ACKed 
     */
    @MavlinkEntryInfo(0)
    MAV_FTP_OPCODE_NONE,

    /**
     * TerminateSession: Terminates open Read session 
     */
    @MavlinkEntryInfo(1)
    MAV_FTP_OPCODE_TERMINATESESSION,

    /**
     * ResetSessions: Terminates all open read sessions 
     */
    @MavlinkEntryInfo(2)
    MAV_FTP_OPCODE_RESETSESSION,

    /**
     * ListDirectory. List files and directories in path from offset 
     */
    @MavlinkEntryInfo(3)
    MAV_FTP_OPCODE_LISTDIRECTORY,

    /**
     * OpenFileRO: Opens file at path for reading, returns session 
     */
    @MavlinkEntryInfo(4)
    MAV_FTP_OPCODE_OPENFILERO,

    /**
     * ReadFile: Reads size bytes from offset in session 
     */
    @MavlinkEntryInfo(5)
    MAV_FTP_OPCODE_READFILE,

    /**
     * CreateFile: Creates file at path for writing, returns session 
     */
    @MavlinkEntryInfo(6)
    MAV_FTP_OPCODE_CREATEFILE,

    /**
     * WriteFile: Writes size bytes to offset in session 
     */
    @MavlinkEntryInfo(7)
    MAV_FTP_OPCODE_WRITEFILE,

    /**
     * RemoveFile: Remove file at path 
     */
    @MavlinkEntryInfo(8)
    MAV_FTP_OPCODE_REMOVEFILE,

    /**
     * CreateDirectory: Creates directory at path 
     */
    @MavlinkEntryInfo(9)
    MAV_FTP_OPCODE_CREATEDIRECTORY,

    /**
     * RemoveDirectory: Removes directory at path. The directory must be empty. 
     */
    @MavlinkEntryInfo(10)
    MAV_FTP_OPCODE_REMOVEDIRECTORY,

    /**
     * OpenFileWO: Opens file at path for writing, returns session 
     */
    @MavlinkEntryInfo(11)
    MAV_FTP_OPCODE_OPENFILEWO,

    /**
     * TruncateFile: Truncate file at path to offset length 
     */
    @MavlinkEntryInfo(12)
    MAV_FTP_OPCODE_TRUNCATEFILE,

    /**
     * Rename: Rename path1 to path2 
     */
    @MavlinkEntryInfo(13)
    MAV_FTP_OPCODE_RENAME,

    /**
     * CalcFileCRC32: Calculate CRC32 for file at path 
     */
    @MavlinkEntryInfo(14)
    MAV_FTP_OPCODE_CALCFILECRC,

    /**
     * BurstReadFile: Burst download session file 
     */
    @MavlinkEntryInfo(15)
    MAV_FTP_OPCODE_BURSTREADFILE,

    /**
     * ACK: ACK response 
     */
    @MavlinkEntryInfo(128)
    MAV_FTP_OPCODE_ACK,

    /**
     * NAK: NAK response 
     */
    @MavlinkEntryInfo(129)
    MAV_FTP_OPCODE_NAK
}
