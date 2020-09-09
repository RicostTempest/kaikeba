package com.windsoft.demo4;

public class BookTest {
    public static void main(String[] args) {
        new Book("亿流量级Java并发开发",638).detail();
        System.out.println(Student.getCompany());
        new Student().test(1,2,3);
        Clothing c1 = new Clothing("1");
        Clothing c2 = new Clothing("2");
        Clothing c3 = new Clothing("3");
        Clothing c4 = new Clothing("4");
        c1.show();
        c2.show();
        c3.show();
        c4.show();
    }
}
