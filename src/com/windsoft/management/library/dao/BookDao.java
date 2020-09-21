package com.windsoft.management.library.dao;

import com.windsoft.demo4.Student;
import com.windsoft.management.library.bean.Book;
import com.windsoft.management.library.bean.BookList;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class BookDao {
    BookList bookList = new BookList();

    public List<Book> getAll() {
        return bookList.getBooks();
    }

    private void save(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("resources//library//books"));
            oos.writeObject(bookList.getBooks());
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean add(Book book){
        try {
            for (Book item :
                    bookList.getBooks()) {
                if (item.equals(book)) {
                    return false;
                }
            }
            try {
                book.setCode(bookList.getBooks().get(bookList.getBooks().size()-1).getCode()+1);
            }catch (NullPointerException e){
                book.setCode(1);
            }
            bookList.getBooks().add(book);
            return true;
        }catch (Exception e){
            return false;
        }
        finally {
            save();
        }
    }

    public boolean delete(int code){
        try{
            Book book = findByCode(code);
            if (book != null){
                bookList.getBooks().remove(book);
                return true;
            }
        }catch (Exception e){
            return false;
        }finally {
            save();
        }
        return false;
    }

    public boolean update(Book book){
        try{
            Book old = findByCode(book.getCode());
            if (old != null){
                old.setName(book.getName());
                return true;
            }
        }catch (NullPointerException e){
            System.out.println("未查找的相关图书");
            return false;
        }finally {
            save();
        }
        return false;
    }

    public Book findByCode(int code){
        for (Book item :
                bookList.getBooks()) {
            if (item != null && item.getCode() == code)
                return item;
        }
        return null;
    }

    public List<Book> fuzzyLogicByName(String key){
        List<Book> books = new ArrayList<>();
        for (Book item :
                bookList.getBooks()) {
            try{
                if (item.getName().contains(key)){
                    books.add(item);
                }
            }catch (NullPointerException e){
                System.out.println("图书信息损坏");
            }
        }
        return books;
    }

    public List<Book> sortPriceCollateSequence(){
        List<Book> list = new ArrayList<>(bookList.getBooks());
        list.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                if (o1.getPrice() >= o2.getPrice())
                    return 1;
                else
                    return -1;
            }
        });
        return list;
    }

    public List<Book> sortPriceInvertedSequence(){
        List<Book> list = new ArrayList<>(bookList.getBooks());
        list.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                if (o1.getPrice() <= o2.getPrice())
                    return 1;
                else
                    return -1;
            }
        });
        return list;
    }

    public List<Book> sortPublicationTime(){
        List<Book> list = new ArrayList<>(bookList.getBooks());
        list.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                if(o1.getPublicationTime().getTime()<o2.getPublicationTime().getTime()){
                    return 1;
                }else{
                    return -1;
                }
            }
        });

        return list;
    }
}
