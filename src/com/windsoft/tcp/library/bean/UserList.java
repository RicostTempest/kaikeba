package com.windsoft.tcp.library.bean;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.LinkedList;

public class UserList implements Serializable {
    private LinkedList<User> users;

    public UserList() {

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("resources//tcp//library//users"));
            users = (LinkedList<User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            this.users = new LinkedList<>();
        }
    }

    public LinkedList<User> getUsers() {
        return users;
    }

    public void setUsers(LinkedList<User> users) {
        this.users = users;
    }
}
