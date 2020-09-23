package com.windsoft.demo8;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Demo2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Person> pClass = (Class<Person>) Class.forName("com.windsoft.demo8.Person");
//        Constructor<Person> c1 = pClass.getConstructor();
//        Person p = c1.newInstance();
//        System.out.println(p);

//        Constructor<Person> constructor = pClass.getConstructor(String.class, int.class);
//        Person p2 = constructor.newInstance("Ricost",21);
//        System.out.println(p2);
        /**
         * 调用无参构造方法
         */
        Constructor<Person> c3 = pClass.getDeclaredConstructor(String.class);
        c3.setAccessible(true);
        Person p3 = c3.newInstance("Leaf");
        System.out.println(p3);

    }
}
