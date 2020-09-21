package com.windsoft.tcp.library.customer;

import com.windsoft.tcp.library.bean.User;
import com.windsoft.tcp.library.dao.UserDao;
import com.windsoft.tcp.library.dto.BaseResult;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Customer {

    public boolean login(User user){
        try {
            Socket socket = new Socket("127.0.0.1",55565);
            OutputStream os = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(user);
            InputStream is = socket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            BaseResult baseResult = (BaseResult) ois.readObject();
            return baseResult.getStatus() == BaseResult.STATUS_SUCCESS;
        }catch (NullPointerException e){
            e.printStackTrace();
        } catch (UnknownHostException e) {
            System.out.println("服务器无连接");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean register(User user){
        try {
            Socket socket = new Socket("127.0.0.1",55566);
            OutputStream os = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(user);
            InputStream is = socket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            BaseResult baseResult = (BaseResult) ois.readObject();
            return baseResult.getStatus() == BaseResult.STATUS_SUCCESS;
        }catch (NullPointerException e){
            e.printStackTrace();
        } catch (UnknownHostException e) {
            System.out.println("服务器无连接");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
