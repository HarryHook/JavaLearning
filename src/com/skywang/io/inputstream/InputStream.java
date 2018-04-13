package com.skywang.io.inputstream;

import java.io.Closeable;
import java.io.IOException;

public abstract class InputStream implements Closeable {
    // 能skip的大小
    private static final int MAX_SKIP_BUFFER_SIZE = 2048;

    // 从输入流中读取数据的下一个字节。
    public abstract int read() throws IOException;

    // 将数据从输入流读入 byte 数组。
    public int read(byte[] buff) throws IOException {
        return read(buff, 0, buff.length);
    }

    // 将最多 len 个数据字节从此输入流读入 byte 数组。
    public int read(byte[] buff, int offset, int length) throws IOException {
        if (buff == null) {
            throw new NullPointerException();
        } else if (offset < 0 || length < 0 || length > buff.length - offset) {
            throw new IndexOutOfBoundsException();
        } else if (length == 0) {
            return 0;
        }
        int c = read();
        if (c == -1) {
            return -1;
        }
        buff[offset] = (byte) c;
        int i = 1;
        try {
            for (; i < length; i++) {
                c = read();
                if (c == -1) {
                    return -1;
                }
                buff[offset + i] = (byte) c;
            }
        } catch (IOException E) {

        }
        return i;
    }

    public long skip(long n) throws IOException {
        long remaining = n;
        int nr;
        if (n <= 0) {
            return 0;
        }
        int size = (int) Math.min(MAX_SKIP_BUFFER_SIZE, remaining);
        byte[] skipBuffer = new byte[size];
        while (remaining > 0) {
            nr = read(skipBuffer, 0, (int) Math.min(size, remaining));
            if (nr < 0) {
                break;
            }
            remaining -= nr;
        }
        return n - remaining;
    }

    public int available() throws IOException {
        return 0;
    }

    public void close() throws IOException {
    }

    public synchronized void mark() throws IOException {
    }

    public synchronized void reset() throws IOException {
      
    }

    public boolean markSupported() {
        return false;
    }
}



