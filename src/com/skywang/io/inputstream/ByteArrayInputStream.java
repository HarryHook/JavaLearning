package com.skywang.io.inputstream;

import java.io.IOException;

public class ByteArrayInputStream extends InputStream {
    protected byte[] buff;  //字节数组
    protected int pos;      //下一个被读取的索引的位置
    protected int mark;     //标记的索引
    protected int count;    //字节流长度

    public ByteArrayInputStream(byte[] buff) {
        this.buff = buff;
        this.pos = 0;
        this.count = buff.length;
    }

    public ByteArrayInputStream(byte[] buff, int offset, int length) {
        this.buff = buff;
        this.pos = offset;
        this.count = Math.min(offset + length, buff.length);
        this.mark = offset;
    }

    public synchronized int read() {
        return (pos < count) ? (buff[pos++] & 0xff) : -1;
    }

    // 将“字节流的数据写入到字节数组b中”
    // off是“字节数组b的偏移地址”，表示从数组b的off开始写入数据
    // len是“写入的字节长度”
    public synchronized int read(byte[] b, int off, int length) {
        if (b == null) {
            throw new NullPointerException();
        } else if (off < 0 || length < 0 || length > b.length - off) {
            throw new IndexOutOfBoundsException();
        }
        if (pos >= count) {
            return -1;
        }
        int avail = count - pos;
        if (length > avail) {
            length = avail;
        }
        if (length <= 0) {
            return 0;
        }
        System.arraycopy(buff, pos, b, off, length);
        pos += length;
        return length;
    }

    // 跳过“字节流”中的n个字节。
    public synchronized long skip(long n) {
        long k = count - pos;
        if (n < k) {
            k = n < 0 ? 0 : n;
        }
        pos += k;
        return k;
    }

    //能否读取字节流下一个字节
    public synchronized int available() {
        return count - pos;
    }

    //是否支持标签
    public boolean markSupported() {
        return true;
    }

    //保存当前位置， readAheadLimit在此处没有意义
    public void mark(int readAheadLimit) {
        mark = pos;
    }

    public void reset() {
        pos = mark;
    }

    public void close() throws IOException {

    }
}
