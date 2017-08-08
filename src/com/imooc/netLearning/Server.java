package com.imooc.netLearning;


import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 基于TCP协议的Socket通信，实现用户登录
 * 服务器端
 */
public class Server {

    public static void main(String[] args) {

	try {
	    // 1.创建服务器端Socket, 指定绑定端口,并监听此端口
	    ServerSocket server = new ServerSocket(1333);
	    //记录客户端的连接数量
	    int count = 0;
	    Socket socket = null;
	    System.out.println("服务器即将启动，等待客户端连接");
	    while (true) {
		// 2.调用accept()方法，监听客户端，等待连接
		socket = server.accept();
		// 创建一个新的线程
		ServerThread serverThread = new ServerThread(socket);
		// 启动线程
		serverThread.start();
		// 线程数量
		count ++;
		System.out.println("客户端数量： " + count);
		InetAddress address = socket.getInetAddress();
		System.out.println("客户端的IP地址信息： " + address.getHostAddress());
	    }
 
	} catch (IOException e) {
	    e.printStackTrace();
	} 

    }

}
