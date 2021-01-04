package com.cai.SocketTest;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author: Cai
 * @date: 2020/11/4 17:06
 * @description:
 */
public class Test1 {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("10.20.242.117",8888);
        OutputStream os = socket.getOutputStream();
        os.write("hello newworld".getBytes());
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        System.out.println(new String(bytes,0,len));

        socket.close();
    }
}
