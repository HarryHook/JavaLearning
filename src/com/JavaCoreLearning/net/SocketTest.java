package com.JavaCoreLearning.net;

import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class SocketTest {

    public static void main(String[] args) {
	try {
	    Socket socket = new Socket("time-A.timefreq.bldrdoc.gov", 13);
	    try {
		InputStream inputStream = socket.getInputStream();
		Scanner in = new Scanner(inputStream);
		while (in.hasNextLine()) {
		    String line = in.nextLine();
		    System.out.println(line);
		}
	    } finally {
		socket.close();
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

}
