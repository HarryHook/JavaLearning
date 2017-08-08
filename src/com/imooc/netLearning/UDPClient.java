package com.imooc.netLearning;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
/*
 * UDP客户端实现
 */
public class UDPClient {

    public static void main(String[] args) throws IOException {
	
	//1.定义服务器的地址，端口号，数据
	InetAddress address = InetAddress.getByName("127.0.0.1");
	int port = 1334;
	byte[] bytes ="用户名：admin; 密码：123".getBytes();
	//2.创建数据报，包含发送的信息
	DatagramPacket packet = new DatagramPacket(bytes, bytes.length, address, port);
	//3.创建DatagramSocket对象
	DatagramSocket socket = new DatagramSocket();
	//4.使用DatagramSocket向服务器端发送数据报
	socket.send(packet);
	
	/*
	 * 接收服务器响应的数据
	 */
	//1.创建数据报，用于接收服务器端响应的数据
	byte[] data = new byte[1024];
	DatagramPacket packet2 = new DatagramPacket(data, data.length);
	//2.接收服务器端响应的数据
	socket.receive(packet2);
	//3.读取数据
	String info = new String(data, 0, packet2.getLength());
	System.out.println("我是客户端,服务器说： " + info);	
	//4.关闭资源
	socket.close();
    }

}
