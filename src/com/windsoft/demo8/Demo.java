package com.windsoft.demo8;

import java.lang.annotation.*;

public class Demo {
    @MyAnnotation(value = "张三",num = 100)
    public static void main(String[] args) {

    }
}
//是否用在文档中
@Documented
//用途类型
@Target({ElementType.TYPE, ElementType.METHOD})
//保存策略
@Retention(RetentionPolicy.RUNTIME)
//可以继承
@Inherited
@interface MyAnnotation{
    String value();
    int num() default 1;
}