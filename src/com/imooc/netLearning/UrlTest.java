package com.imooc.netLearning;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlTest {

    public static void main(String[] args) {
	try {
	    //创建URL实例
	    URL imooc = new URL("http://www.imooc.com");
	    //?后表示参数#后表示锚点
	    URL url = new URL(imooc, "/index.html?username=tom#forjob");
	    System.out.println("协议信息： " + url.getProtocol());
	    System.out.println("主机信息： " + url.getHost());
	    //http默认端口号为80，未指定端口号返回-1
	    System.out.println("端口号信息： " + url.getPort());
	    System.out.println("文件路径： " + url.getPath());
	    System.out.println("文件名: " + url.getFile());
	    System.out.println("文件相对路径 :" + url.getRef());
	    System.out.println("查询字符串： " + url.getQuery());
	} catch (MalformedURLException e) {
	    e.printStackTrace();
	}

    }

}
