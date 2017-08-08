package com.imooc.netLearning;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * 服务器端，实现UDP的用户登录
 */
public class UDPServer {

    public static void main(String[] args) throws IOException {
	/*
	 * 接收客户端数据
	 */
	// 1.创建DatagramSocket, 指定端口
	DatagramSocket socket = new DatagramSocket(1334);
	// 2.创建数据报，用于接收客户端发送的信息
	byte[] bytes = new byte[1024];
	DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
	System.out.println("***服务器端已启动！等待客户端发送数据***");
	// 3.接受客户端发送的信息
	socket.receive(packet); // 此方法在接收到数据前会一直阻塞
	// 4.读取数据
	String info = new String(bytes, 0, packet.getLength());
	System.out.println("客户端发送的信息： " + info);

	/*
	 * 向客户端发出响应
	 */
	//1.定义客户端地址、端口、数据
	InetAddress address = packet.getAddress();
	int port = packet.getPort();
	byte[] data = "欢迎客户端".getBytes();
	//2.创建数据报，包含响应的数据信息
	DatagramPacket packet2 = new DatagramPacket(data, data.length, address, port);
	//3.响应客户端
	socket.send(packet2);
	//4.关闭资源信息
	socket.close();
	
	
    }

}
