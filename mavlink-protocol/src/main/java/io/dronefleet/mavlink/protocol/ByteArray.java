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

    public void putInt48(long value, int offset) {
        putLong(value, offset, 6);
    }

    public byte[] slice(int offset, int size) {
        byte[] value = new byte[size];
        System.arraycopy(bytes, offset, value, 0, size);
        return value;
    }

    public long getLong(int offset, int size) {
        long value = 0;
        for (int i = 0; i < size; i++) {
            value |= (bytes[offset+i] & 0xff) << (i * Byte.SIZE);
        }
        return value;
    }

    public void putLong(long value, int offset, int size) {
        for (int i = 0; i < size; i++) {
            bytes[offset+i] = (byte)((value >> (i * Byte.SIZE)) & 0xFF);
        }
    }

    public byte[] array() {
        return bytes;
    }

    public int length() {
        return bytes.length;
    }
}
