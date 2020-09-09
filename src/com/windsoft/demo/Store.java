package com.windsoft.demo;

import java.util.Scanner;

public class Store {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input consumption");
        float consumption = scanner.nextFloat();
        System.out.println("please input integral");
        int integral = scanner.nextInt();

        if(integral< 2000){
            consumption = consumption*0.9f;
        }else if(integral < 4000){
            consumption = consumption*0.8f;
        }else if(integral < 8000){
            consumption = consumption*0.75f;
        }else {
            consumption = consumption*0.7f;
        }

        System.out.println("actual consumption:"+consumption);
    }
}
