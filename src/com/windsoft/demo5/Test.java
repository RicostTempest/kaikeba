package com.windsoft.demo5;

public class Test {
    public static void main(String[] args) {
//        new FingerGuessingMachine("Hownk",3);
//        new UserService().scanner();
        DynamicArray dynamicArray = new DynamicArray();
        System.out.println(dynamicArray.length);
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);
        dynamicArray.add(4);
        dynamicArray.add(5);
        dynamicArray.add(6);
        dynamicArray.add(7);
        dynamicArray.remove(1);
        System.out.println(dynamicArray.length);
    }
}
