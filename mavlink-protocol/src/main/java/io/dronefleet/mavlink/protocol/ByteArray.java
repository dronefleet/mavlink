package io.dronefleet.mavlink.protocol;

class ByteArray {
    private final byte[] bytes;

    ByteArray(byte[] bytes) {
        this.bytes = bytes;
    }

    public int getInt8(int offset) {
        return (int)getLong(offset, 1);
    }

    public void putInt8(int value, int offset) {
        putLong(value, offset, 1);
    }

    public int getInt16(int offset) {
        return (int)getLong(offset, 2);
    }

    public void putInt16(int value, int offset) {
        putLong(value, offset, 2);
    }

    public int getInt24(int offset) {
        return (int)getLong(offset, 3);
    }

    public void putInt24(int value, int offset) {
        putLong(value, offset, 3);
    }

    public byte[] slice(int offset, int length) {
        byte[] value = new byte[length];
        System.arraycopy(bytes, offset, value, 0, length);
        return value;
    }

    public long getLong(int offset, int length) {
        long value = 0;
        for (int i = offset; i < offset + length; i++) {
            value = (value << 8) | (bytes[i] & 0xff);
        }
        return value;
    }

    public void putLong(long value, int offset, int length) {
        for (int i = offset; i < offset + length; i++) {
            bytes[i] = (byte)((value >> (8 * ((length+offset) - 1 - i))) & 0xff);
        }
    }

    public byte[] array() {
        return bytes;
    }

    public int length() {
        return bytes.length;
    }
}
