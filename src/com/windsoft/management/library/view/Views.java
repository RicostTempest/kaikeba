package com.windsoft.management.library.view;

import com.windsoft.management.library.bean.Book;
import com.windsoft.management.library.bean.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class Views {
    /**
     * 输入
     */
    private Scanner input = new Scanner(System.in);
    /**
     * 日期格式
     */
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 欢迎页
     */
    public int welcome(){
        System.out.println("欢迎使用WINDSOFT图书管理系统");
        System.out.println("1.登录");
        System.out.println("2.注册");
        System.out.println("0.退出");
        String text = input.nextLine();
        int num = -1;
        try {
            num = Integer.parseInt(text);
        }catch (NumberFormatException e){

        }
        if (num < 0 || num > 4)
            return welcome();
        return num;
    }

    /**
     * 结束页
     */
    public void by(){
        System.out.println("下次再回");
    }

    /**
     * 登录
     * @return 输入的帐号和密码
     */
    public User singIn(){
        User user = new User();
        System.out.print("输入帐号：");
        user.setUsername(input.nextLine());
        System.out.print("输入密码：");
        user.setPassword(input.nextLine());
        return user;
    }
    /**
     * 注册
     * @return 输入的帐号和密码
     */
    public User sinUp(){
        User user = new User();
        System.out.print("输入新帐号：");
        user.setUsername(input.nextLine());
        System.out.print("输入密码：");
        user.setPassword(input.nextLine());
        return user;
    }

    /**
     * 系统选项
     * @return 现象编号
     */
    public int menu(){
        System.out.println("可以使用以下功能");
        System.out.println("1.新增图书");
        System.out.println("2.修改图书");
        System.out.println("3.删除图书");
        System.out.println("4.查看图书");
        System.out.println("5.排序输出");
        System.out.println("0.退出");
        String text = input.nextLine();
        int num = -1;
        try {
            num = Integer.parseInt(text);
        }catch (NumberFormatException e){

        }
        if (num < 0 || num > 5)
            return menu();
        return num;
    }

    /**
     * 输入查找编号
     * @return 图书编号
     */
    public int search(){
        try {
            System.out.print("输入查找的编号：");
            return Integer.parseInt(input.nextLine());
        }catch (NumberFormatException e){
            System.out.println("输入正确的编号");
            return search();
        }
    }
    /**
     * 添加图书
     * @return 新增图书
     */
    public Book add(){
        Book book = new Book();
        System.out.print("输入图书名称：");
        book.setName(input.nextLine());
        System.out.print("输入图书作者：");
        book.setAuthor(input.nextLine());
        System.out.print("输入图书出版社：");
        book.setPublisher(input.nextLine());
        //输入价格
        while (true){
            try {
                System.out.print("输入图书价格：");
                book.setPrice(Float.parseFloat(input.nextLine()));
                break;
            }catch (NumberFormatException e){
                System.out.println("请输入正确的价格（支持小数点）");
            }
        }
        //输入出版时间
        while (true) {
            try {
                System.out.print("输入图书出版时间：(示例:1999-01-03)");
                book.setPublicationTime(df.parse(input.nextLine()));
                break;
            } catch (ParseException e) {
                System.out.println("格式错误");
            }
        }

        return book;
    }

    /**
     * 编辑书籍信息菜单
     * @param book 需要编辑的书籍对象
     * @return 修改过后的图书对象
     */
    public Book update(Book book){
        if(book == null)
            return null;
        while (true){
            System.out.println("选择要修改的内容");
            System.out.println("1.修改图书名称");
            System.out.println("2.修改作者");
            System.out.println("3.修改出版社");
            System.out.println("4.修改价格");
            System.out.println("5.修改出版时间");
            System.out.println("0.修改完成");
            String text = input.nextLine();
            int num = -1;
            try {
                num = Integer.parseInt(text);
            }catch (NumberFormatException ignored){

            }
            if (num < 0 || num > 5)
                return update(book);

            switch (num){
                case 1:
                    System.out.print("输入图书名称：");
                    book.setName(input.nextLine());
                    continue;
                case 2:
                    System.out.print("输入图书作者：");
                    book.setAuthor(input.nextLine());
                    continue;
                case 3:
                    System.out.print("输入图书出版社：");
                    book.setPublisher(input.nextLine());
                    continue;
                case 4:
                    while (true){
                        try {
                            System.out.print("输入图书价格：");
                            book.setPrice(Float.parseFloat(input.nextLine()));
                            break;
                        }catch (NumberFormatException e){
                            System.out.println("请输入正确的价格（支持小数点）");
                        }
                    }
                    continue;
                case 5:
                    while (true) {
                        try {
                            System.out.print("输入图书出版时间：(示例:1999-01-03)");
                            book.setPublicationTime(df.parse(input.nextLine()));
                            break;
                        } catch (ParseException e) {
                            System.out.println("格式错误");
                        }
                    }
                    continue;
                case 0:
                    break;
            }
            break;
        }
        return book;
    }

    /**
     * 删除菜单
     * @return 是否删除
     */
    public boolean delete(){
        while (true){
            System.out.println("是否删除");
            System.out.println("1.删除");
            System.out.println("0.取消");
            String text = input.nextLine();
            int num = -1;
            try {
                num = Integer.parseInt(text);
            }catch (NumberFormatException ignored){
                System.out.println("请选择操作选项");
            }
            if (num < 0 || num > 1)
                return delete();

            switch (num){
                case 1:
                    return true;
                case 0:
                    return false;
            }
        }
    }

    /**
     * 选择排序方式
     * @return 序号1~3
     */
    public int sort(){
        System.out.println("选择排序方式");
        System.out.println("1.价格从高到低");
        System.out.println("2.价格从低到高");
        System.out.println("3.出版日期");
        String text = input.nextLine();
        int num = -1;
        try {
            num = Integer.parseInt(text);
        }catch (NumberFormatException ignored){

        }
        if (num < 0 || num > 3)
            return sort();
        return num;
    }

    /**
     * 显示全部书籍信息
     * @param books 需要打印信息的List
     */
    public void showAll(List<Book> books){
        for (Book book :
                books) {
            printBookInfo(book);
        }
    }
    /**
     * 打印图书信息
     * @param book 需要打印的图书对象
     */
    public void printBookInfo(Book book){
        if(book != null){
            System.out.println("图书编号：" + book.getCode());
            System.out.println("图书名称：" + book.getName());
            System.out.println("图书作者：" + book.getAuthor());
            System.out.println("图书出版社：" + book.getPublisher());
            System.out.println("图书价格：" + book.getPrice());
            System.out.println("图书出版时间：" + df.format(book.getPublicationTime()));
        }else {
            System.out.println("图书信息错误");
        }
    }

    /**
     * 模糊查询
     * @return 需要查找的字段
     */
    public String fuzzySearch(){
        System.out.print("输入要查找的字段：");
        return input.nextLine();
    }

}
