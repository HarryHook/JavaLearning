package com.skywang.io.outputstream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class ByteArrayOutputStream extends OutputStream {
    // 保存“字节数组输出流”数据的数组
    protected byte[] buff;
    // “字节数组输出流”的计数
    protected int count = 0;

    public ByteArrayOutputStream() {
        this(32);
    }

    public ByteArrayOutputStream(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Negative initial size: " + size);
        }
        buff = new byte[size];
    }

    // 确认“容量”。若“实际容量 < minCapacity”，则增加“字节数组输出流”的容量
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > buff.length) {
            grow(minCapacity);
        }
    }

    // 增加“容量”。
    private void grow(int minCapacity) {
        int oldCapacity = buff.length;
        // “新容量”的初始化 = “旧容量”x2
        int newCapacity = oldCapacity << 1;
        // 比较“新容量”和“minCapacity”的大小，并选取其中较大的数为“新的容量”。
        if (newCapacity < minCapacity) {
            newCapacity = minCapacity;
        }
        if (newCapacity < 0) {
            if (minCapacity < 0) {
                //overfolw
                throw new OutOfMemoryError();
            }
            newCapacity = Integer.MAX_VALUE;
        }
        buff = Arrays.copyOf(buff, newCapacity);
    }

    // 写入一个字节b到“字节数组输出流”中，并将计数+1
    public synchronized void write(int b) {
        ensureCapacity(count + 1);
        buff[count] = (byte) b;
        count++;
    }

    // 写入字节数组b到“字节数组输出流”中。off是“写入字节数组b的起始位置”，len是写入的长度
    public synchronized void write(byte b[], int off, int len) {
        if ((off < 0) || (off > b.length) || (len < 0) || ((off + len) > b.length)) {
            throw new IndexOutOfBoundsException();
        }
        ensureCapacity(count + len);
        System.arraycopy(b, off, buff, count, len);
        count += len;
    }

    // 写入输出流outb到“字节数组输出流”中。
    public synchronized void writeTo(OutputStream out) throws IOException {
        out.write(buff, 0, count);
    }

    // 重置“字节数组输出流”的计数。
    public synchronized void reset() {
        count = 0;
    }

    // 返回“字节数组输出流”当前计数值
    public synchronized int size() {
        return count;
    }

    //转换成字节数组
    public synchronized byte[] toByteArray() {
        return Arrays.copyOf(buff, count);
    }

    public synchronized String toString() {
        return new String(buff, 0, count);
    }

    public synchronized String toString(String charsetName) throws UnsupportedEncodingException {
        return new String(buff, 0, count, charsetName);
    }

    @Deprecated
    public synchronized String toString(int hibyte) {
        return new String(buff, hibyte, 0, count);
    }

    public void close() throws IOException {

    }
}
