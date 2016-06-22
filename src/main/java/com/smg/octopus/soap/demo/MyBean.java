package com.smg.octopus.soap.demo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.activation.DataHandler;

public class MyBean {
	
	private static final int INITIAL_SIZE = 1024 * 1024;
	private static final int BUFFER_SIZE = 1024;
	
public void print(byte[] handler){
		System.out.println(new String((handler)));

	
}

private static byte[] toBytes(DataHandler dh) throws IOException {
    ByteArrayOutputStream bos = new ByteArrayOutputStream(INITIAL_SIZE);
    InputStream in = dh.getInputStream();
    byte[] buffer = new byte[BUFFER_SIZE];
    int bytesRead;
    while ( (bytesRead = in.read(buffer)) >= 0 ) {
        bos.write(buffer, 0, bytesRead);
    }
    return bos.toByteArray();
}
}
