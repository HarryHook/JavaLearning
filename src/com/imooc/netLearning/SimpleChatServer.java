package com.imooc.netLearning;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class SimpleChatServer {

    public class ClientHandler implements Runnable {

	BufferedReader reader;
	Socket socket;

	public ClientHandler(Socket clientSocket) {
	    try {
		socket = clientSocket;
		InputStreamReader inReader = new InputStreamReader(socket.getInputStream());
		reader = new BufferedReader(inReader);

	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}

	@Override
	public void run() {
	    String message;
	    try {
		while ((message = reader.readLine()) != null) {
		    System.out.println("read " + message);
		    tellEveryone(message);
		}
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}

	private void tellEveryone(String message) {
	    Iterator it = clientOutputStreams.iterator();
	    while (it.hasNext()) {
		try {
		    PrintWriter writer = (PrintWriter) it.next();
		    writer.println(message);
		    writer.flush();
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }

	}

    }

    public static void main(String[] args) {
	new SimpleChatServer().go();

    }

    ArrayList clientOutputStreams;

    private void go() {
	clientOutputStreams = new ArrayList<>();
	try {
	    ServerSocket serverSocket = new ServerSocket(5000);
	    while (true) {
		Socket clientSocket = serverSocket.accept();
		PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
		clientOutputStreams.add(writer);

		Thread t = new Thread(new ClientHandler(clientSocket));
		t.start();
		System.out.println("got a connection");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

}
