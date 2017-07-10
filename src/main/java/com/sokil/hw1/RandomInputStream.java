package com.sokil.hw1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class RandomInputStream extends InputStream {
    private Random generator = new Random();
    private boolean closed = false;

    @Override
    public int read() throws IOException {
        checkOpen();
        int result = generator.nextInt() % 256;
        if (result < 0) result = -result;
        return result;
    }

    public byte[] read(int byt) throws IOException {
        byte[] data = new byte[byt];
        checkOpen();
        generator.nextBytes(data);
        return data;
    }

    private void checkOpen() throws IOException {
        if (closed) throw new IOException("Input stream closed");
    }
}
