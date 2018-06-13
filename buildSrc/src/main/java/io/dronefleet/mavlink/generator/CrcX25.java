package io.dronefleet.mavlink.generator;

import java.nio.charset.StandardCharsets;

public class CrcX25 {
    private int crc;

    public CrcX25() {
        crc = 0xffff;
    }

    public void accumulate(String str) {
        accumulate(str.getBytes(StandardCharsets.UTF_8));
    }

    public void accumulate(byte[] bytes) {
        for (byte b : bytes) {
            accumulate(b);
        }
    }

    public void accumulate(int b) {
        b = b ^ (crc & 0xff);
        b ^= (b << 4) & 0xff;
        crc = (crc >> 8) ^ (b << 8) ^ (b << 3) ^ (b >> 4);
    }

    public int get() {
        return (crc ^ (crc >> 8));
    }
}
