package com.windsoft.management.library.bean;

import java.io.*;
import java.util.ArrayList;

public class BookList implements Serializable {
    private ArrayList<Book> books;

    public BookList() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("resources//library//books"));
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
