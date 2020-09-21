package com.windsoft.tcp.library.main;

import com.windsoft.tcp.library.dao.BookDao;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Test {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        BookDao bookDao = new BookDao();

//        Book book = new Book();
//        book.setName("PHP");
//        book.setAuthor("龙傲天");
//        book.setPublisher("北京大学出版社");
//        book.setPrice(45.5F);
//        book.setPublicationTime(df.parse("2017-3-5"));
//        bookDao.add(book);
//        System.out.println(bookDao.getAll().size());
//        List<Book> sortList = bookDao.sortPriceCollateSequence();
//        List<Book> list = bookDao.getAll();
//        for (Book item :
//                list) {
//            System.out.println(item.toString());
//        }
//        System.out.println("sort:");
//        for (Book item :
//                sortList) {
//            System.out.println(item.toString());
//        }
//        System.out.println("before");
//        for (Book item :
//                list) {
//            System.out.println(item.toString());
//        }
        String i = "叶磊琴";
        System.out.println(i.contains("a"));
    }
}
