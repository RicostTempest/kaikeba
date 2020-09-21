package com.windsoft.management.library.main;

import com.windsoft.management.express.bean.Express;
import com.windsoft.management.library.bean.Book;
import com.windsoft.management.library.dao.BookDao;
import com.windsoft.management.library.dao.UserDao;
import com.windsoft.management.library.view.Views;

import java.util.List;

public class Main {
    public static UserDao userDao = new UserDao();
    public static BookDao bookDao = new BookDao();
    public static Views v = new Views();
    public static void main(String[] args) {
        switch (v.welcome()){
            case 1:
                if (login()){
                    library();
                }
                break;
            case 2 :
                if (register()) {
                    library();
                }else {
                    v.welcome();
                }
                break;
            case 0:break;
        }

    }

    public static boolean login(){
        int i = 3;
        while (i>0){
            if (userDao.login(v.singIn())){
                return true;
            }else {
                System.out.println("帐号密码错误");
                i--;
                System.out.println("剩余："+i+"次机会");
            }
        }
        return false;
    }

    public static boolean register(){
        if (userDao.register(v.sinUp())){
            System.out.println("注册成功");
            return true;
        } else {
            System.out.println("帐号已存在");
            return false;
        }
    }

    public static void library(){
        Book book = null;
        while (true){
            switch (v.menu()){
                case 1:
                    bookDao.add(v.add());
                    continue;
                case 2 :
                    book = bookDao.findByCode(v.search());
                    v.printBookInfo(book);
                    v.update(book);
                    continue;
                case 3:
                    book = bookDao.findByCode(v.search());
                    if (book != null){
                        v.printBookInfo(book);
                        if (v.delete()){
                           if (bookDao.delete(book.getCode())){
                               System.out.println("删除成功");
                           }else {
                               System.out.println("删除失败");
                           }
                        }
                    }else{
                        System.out.println("图书不存在");
                    }
                    continue;
                case 4:
                    v.showAll(bookDao.fuzzyLogicByName(v.fuzzySearch()));
                    continue;
                case 5:
                    List<Book> sort = null;
                    switch (v.sort()){
                        case 1:
                            sort = bookDao.sortPriceInvertedSequence();
                            break;
                        case 2:
                            sort = bookDao.sortPriceCollateSequence();
                            break;
                        case 3:
                            sort = bookDao.sortPublicationTime();
                            break;
                    }
                    if (sort != null)
                        v.showAll(sort);
                    else
                        System.out.println("排序错误");
                    continue;
                case 0:break;
            }
            break;
        }
    }

}
