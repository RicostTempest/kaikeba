package com.windsoft.demo8;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class c1 = Class.forName("com.windsoft.demo8.Person");
        Constructor c = c1.getConstructor();
        Object o = c.newInstance();
        Method setName = c1.getMethod("setName", String.class);
        /**
         * 1. 执行方法的对象
         * 2. 调用方法时传递的参数 0-n个
         */
        setName.invoke(o,"Leaf");
        Method say = c1.getDeclaredMethod("say");
        say.setAccessible(true);
        say.invoke(o);
    }
}
