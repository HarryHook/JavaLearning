package com.imooc.netLearning;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetAddressTest {

    public static void main(String[] args) throws UnknownHostException {
	InetAddress address = InetAddress.getLocalHost();
	System.out.println("主机名: " + address.getHostName());
	System.out.println("主机IP地址: " + address.getHostAddress());
	byte[] b = address.getAddress();
	System.out.println("字节数组形式的IP地址: " + Arrays.toString(b));
	System.out.println(address);
	
	InetAddress address2 = InetAddress.getByName("Harry");
	System.out.println("IP地址  " + address2.getHostAddress());
	InetAddress address3 = InetAddress.getByName("169.254.168.254");
	//System.out.println("主机名 " + address3.getHostName());
	System.out.println(address3.getHostName());
    }

}
