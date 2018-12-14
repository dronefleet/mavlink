package io.dronefleet.mavlink.protocol;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

class TransactionalInputStream extends PushbackInputStream {

    private final byte[] buffer;
    private int cbuffer;

    TransactionalInputStream(InputStream in, int bufferSize) {
        super(in, bufferSize);
        buffer = new byte[bufferSize];
        cbuffer = 0;
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        if (c != -1) {
            buffer[cbuffer++] = (byte) c;
        }
        return c;
    }

    void rollback() throws IOException {
        super.unread(buffer, 0, cbuffer);
    }

    boolean advance(int bytes) throws IOException {
        for (int i = 0; i < bytes; i++) {
            if (read() == -1) return false;
        }
        return true;
    }

    void commit() {
        cbuffer = 0;
    }

    public byte[] getBuffer() {
        byte bytes[] = new byte[cbuffer];
        System.arraycopy(buffer, 0, bytes, 0, cbuffer);
        return bytes;
    }

    @Override
    public void unread(int b) throws IOException {
        disallowUnread();
    }

    @Override
    public void unread(byte[] b) throws IOException {
        disallowUnread();
    }

    @Override
    public void unread(byte[] b, int off, int len) throws IOException {
        disallowUnread();
    }

    private void disallowUnread() {
        throw new IllegalStateException("use either commit or rollback instead.");
    }
}
