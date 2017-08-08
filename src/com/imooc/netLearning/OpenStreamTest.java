package com.imooc.netLearning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/*
 * URL读取网页页面信息
 */
public class OpenStreamTest {
    public static void main(String[] args) {
	try {
	    //创建URL实例
	    URL url = new URL("http://www.imooc.com");
	    //openStream()读取url链接
	    InputStream is = url.openStream();
	    //字节流转字符流
	    InputStreamReader isr = new InputStreamReader(is, "utf-8");
	    //将字符流放入缓存
	    BufferedReader br = new BufferedReader(isr);
	    String data = br.readLine();
	    while(data != null) {
		System.out.println(data);
		data = br.readLine();
	    }
	    br.close();
	    isr.close();
	    is.close();
	} catch (MalformedURLException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}
