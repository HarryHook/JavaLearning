package com.imooc.netLearning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * 服务器线程处理类
 */
public class ServerThread extends Thread {
    // 和本线程相关的Socket
    Socket socket = null;

    public ServerThread(Socket socket) {
	this.socket = socket;
    }

    // 执行线程操作
    @Override
    public void run() {
	InputStream is = null;
	InputStreamReader isr = null;
	BufferedReader br = null;
	OutputStream os = null;
	PrintWriter pw = null;
	try {
	    // 获取输入流，得到客户端的请求
	    is = socket.getInputStream();
	    isr = new InputStreamReader(is);
	    br = new BufferedReader(isr);
	    String info = null;
	    while ((info = br.readLine()) != null) {
		System.out.println("我是服务器，客户端对我说： " + info);
	    }
	    socket.shutdownInput(); // 关闭输入流
	    // 获取输出流，响应客户端请求
	    os = socket.getOutputStream();
	    pw = new PrintWriter(os);
	    pw.write("欢迎您！");
	    pw.flush();
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    // 5.关闭资源
	    try {
		if (pw != null) {
		pw.close();
		}
		if (os != null) {
		os.close();
		}
		if(br != null) {
		 br.close();
		}
		if(isr != null) {
		 isr.close();
		}
		if(is != null) {
		  is.close();
		}
		if(socket != null) {
		 socket.close();
		}
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	   

	}

    }
}
