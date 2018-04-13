package com.skywang.io.outputstream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public abstract class OutputStream implements Closeable, Flushable {
    //将字节b写入到“输入流”, 在子类中实现
    public abstract void write(int b) throws IOException;

    //写入字节数组b 到 字节数组 输入流中
    public void write(byte[] b) throws IOException {
        write(b, 0, b.length);
    }

    // 写入字节数组b到“字节数组输出流”中，并且offset是“数组b的起始位置”，length
    public void write(byte[] b, int offset, int length) throws IOException {
        if (b == null) {
            throw new NullPointerException();
        } else if (offset < 0 || length < 0 || offset > b.length) {
            throw new IndexOutOfBoundsException();
        } else if (length == 0) {
            return;
        }
        for (int i = 0; i < length; i++) {
            write(b[offset + i]);
        }
    }


    @Override
    public void close() throws IOException {

    }

    @Override
    public void flush() throws IOException {

    }
}
