package com.windsoft.tcp.library.producer;

import com.windsoft.tcp.library.bean.User;
import com.windsoft.tcp.library.dao.UserDao;
import com.windsoft.tcp.library.dto.BaseResult;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Login {
    private static UserDao userDao = new UserDao();

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(55565);
            System.out.println("用户登录服务器启动");
            Socket socket = server.accept();
            System.out.println("一个客户端连接成功");
            InputStream is = socket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            User user =(User) ois.readObject();
            BaseResult result = new BaseResult();
            if (userDao.login(user)){
                result.setStatus(BaseResult.STATUS_SUCCESS);
            }else{
                result.setStatus(BaseResult.STATUS_FAIL);
            }
            OutputStream os = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(result);
        } catch (IOException e) {
            System.out.println("端口被占用");
        } catch (ClassNotFoundException e) {
            System.out.println("类型转换错误");
        }
    }
}
