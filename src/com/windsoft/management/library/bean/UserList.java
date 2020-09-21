package com.windsoft.management.library.bean;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class UserList implements Serializable {
    private LinkedList<User> users;

    public UserList() {

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("resources//library//users"));
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
