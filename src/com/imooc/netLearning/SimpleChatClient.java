package com.imooc.netLearning;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class SimpleChatClient {
    JTextArea incoming;
    JTextField outgoing;
    BufferedReader reader;
    PrintWriter writer;
    Socket socket;

    public static void main(String[] args) {
	SimpleChatClient client = new SimpleChatClient();
	client.go();
    }

    public void go() {
	JFrame frame = new JFrame("简单的聊天框");
	JPanel mainPanel = new JPanel();
	incoming = new JTextArea(15, 50);
	incoming.setLineWrap(true);
	incoming.setWrapStyleWord(true);
	incoming.setEditable(false);
	JScrollPane qScroller = new JScrollPane(incoming);
	qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	outgoing = new JTextField(20);
	JButton sendButton = new JButton("Send");
	sendButton.addActionListener(new SendButtonListener());
	mainPanel.add(qScroller);
	mainPanel.add(outgoing);
	mainPanel.add(sendButton);
	setUpNetWorking();

	Thread readerThread = new Thread(new IncomingReader());
	readerThread.start();

	frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
	frame.setSize(400, 500);
	frame.setVisible(true);
    }

    private void setUpNetWorking() {
	try {
	    socket = new Socket("127.0.0.1", 5000);
	    InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
	    reader = new BufferedReader(streamReader);
	    writer = new PrintWriter(socket.getOutputStream());
	    System.out.println("NetWorking established");
	} catch (Exception e) {
	    e.printStackTrace();

	}

    }

    public class IncomingReader implements Runnable {

	@Override
	public void run() {
	    String message;
	    try {
		while ((message = reader.readLine()) != null) {
		    System.out.println("read " + message);
		    incoming.append(message + "\n");
		}
	    } catch (Exception e) {
		e.printStackTrace();

	    }
	}

    }

    public class SendButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
	    try {
		writer.println(outgoing.getText());
		writer.flush();
	    } catch (Exception ex) {
		ex.printStackTrace();

	    }
	    outgoing.setText("");
	    outgoing.requestFocus();

	}

    }

}
