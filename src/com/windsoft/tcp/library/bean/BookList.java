package com.windsoft.tcp.library.bean;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class BookList implements Serializable {
    private ArrayList<Book> books;

    public BookList() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("resources//tcp//library//books"));
            books = (ArrayList<Book>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            this.books = new ArrayList<>();
        }
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}
