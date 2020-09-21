package com.windsoft.tcp.library.producer;

import com.windsoft.tcp.library.bean.User;
import com.windsoft.tcp.library.dao.UserDao;
import com.windsoft.tcp.library.dto.BaseResult;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Producer {
    private UserDao userDao = new UserDao();

    public void init(){
        new Thread(this::login).start();
        new Thread(this::register).start();
    }

    private void register(){
        try {
            ServerSocket server = new ServerSocket(55566);
            System.out.println("用户注册服务器启动");
            while (true){
                Socket socket = server.accept();
                new Thread(()->{
                    try {
                        System.out.println("注册业务开始");
                        InputStream is = socket.getInputStream();
                        ObjectInputStream ois = new ObjectInputStream(is);
                        User user =(User) ois.readObject();
                        BaseResult result = new BaseResult();
                        if (userDao.register(user)){
                            result.setStatus(BaseResult.STATUS_SUCCESS);
                        }else{
                            result.setStatus(BaseResult.STATUS_FAIL);
                        }
                        OutputStream os = socket.getOutputStream();
                        ObjectOutputStream oos = new ObjectOutputStream(os);
                        oos.writeObject(result);
                        System.out.println("注册业务结束");
                    } catch (ClassNotFoundException | IOException e) {
                        System.out.println("流读取错误");
                    }
                }).start();
            }
        } catch (IOException e) {
            System.out.println("端口被占用");
        }
    }

    private void login(){
        try {
            ServerSocket server = new ServerSocket(55565);
            System.out.println("用户登录服务器启动");
            while (true){
                Socket socket = server.accept();
                new Thread(()->{
                    try {
                        System.out.println("登陆业务开始");
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
                        System.out.println("登录业务结束");
                    } catch (ClassNotFoundException | IOException e) {
                        System.out.println("流读取错误");
                    }
                }).start();
            }
        } catch (IOException e) {
            System.out.println("端口被占用");
        }
    }
}
