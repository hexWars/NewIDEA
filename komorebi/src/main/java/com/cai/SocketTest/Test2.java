package com.cai.SocketTest;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: Cai
 * @date: 2020/11/4 17:21
 * @description:
 */
public class Test2 {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        System.out.println(new String(bytes,0,len));
        OutputStream outputStream = serverSocket.accept().getOutputStream();
        outputStream.write("收到啦".getBytes());
        accept.close();
        serverSocket.close();
    }
}
