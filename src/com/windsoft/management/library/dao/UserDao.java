package com.windsoft.management.library.dao;

import com.windsoft.management.library.bean.User;
import com.windsoft.management.library.bean.UserList;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class UserDao {
    UserList userList = new UserList();

    /**
     * 注册
     * @param user 存取新信息的User对象
     * @return 注册是否成功
     */
    public boolean register(User user){
        System.out.println(userList.getUsers().size());
        try {
            for (User item :
                    userList.getUsers()) {
                if (item.equals(user)){
                    return false;
                }
            }
            userList.getUsers().add(user);
            save();
            return true;
        }catch (NullPointerException e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 登录
     * @param user 存储登录信息的对象
     * @return 登录是否成功
     */
    public boolean login(User user){
        try {
            for (User item :
                    userList.getUsers()) {
                if (item.equals(user)){
                    return user.getPassword().equals(item.getPassword());
                }
            }
            return false;
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 将对象存储为文件
     */
    public void save(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("resources//library//users"));
            oos.writeObject(userList.getUsers());
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
