package io.dronefleet.mavlink.testtool;

public class CLibraryTestTool {
    static {
        System.loadLibrary("testtool");
    }

    public static native boolean signatureCheck(int linkId, long timestamp, byte secretKey[],
                                           byte packet[]);

    public static native boolean crcCheck(byte packet[]);
}
