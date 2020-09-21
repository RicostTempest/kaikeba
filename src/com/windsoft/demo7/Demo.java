package com.windsoft.demo7;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo {
    /**
     * TCP服务器
     * @param args
     */
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(55565);
        System.out.println("服务器启动完毕");
        Socket socket = server.accept();
        System.out.println("一个客户端连接了");

        OutputStream os = socket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(new Person("Ricost",21));

        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String text = br.readLine();
        System.out.println("服务器接到客户端回复："+text);


        System.out.println("服务器运行结束");
    }
}
