package com.designpatterns.decoration.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputTest {

    public static void main(String[] args) throws IOException {
	int c;
	try {
	    InputStream inputStream = new LowerCaseInputStream(
		    new BufferedInputStream(new FileInputStream("f://1.txt")));
	    while ((c = inputStream.read()) >= 0) {
		System.out.print((char) c);
	    }

	} catch (Exception e) {	
	    e.printStackTrace();

	}

    }

}
