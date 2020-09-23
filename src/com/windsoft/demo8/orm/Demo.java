package com.windsoft.demo8.orm;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c = Class.forName("com.windsoft.demo8.orm.Book");
        Annotation[] as  = c.getAnnotations();
//        for (Annotation a:as){
//            System.out.println(a);
//        }
        TableAnnotation ta = (TableAnnotation) c.getAnnotation(TableAnnotation.class);
        String value = ta.value();
        System.out.println("表名："+value);
        //获取属性
        Field[] fs  = c.getDeclaredFields();
        for (Field f:fs ){
            ColumnAnnotation ca = f.getAnnotation(ColumnAnnotation.class);
            System.out.println(f.getName()+"属性，对应的数据库字段：" + ca.column()+"数据类型：" +ca.type()+"数据长度：" +ca.length());

        }
    }
}
