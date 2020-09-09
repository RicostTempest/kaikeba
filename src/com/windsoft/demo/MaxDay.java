package com.windsoft.demo;

import java.util.Scanner;

public class MaxDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the year");
        int year =  scanner.nextInt();
        System.out.println("Please input the month");
        int day;
        int month =  scanner.nextInt();
        switch (month){
            //大月
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                day = 31;break;
            //小月
            case 4:
            case 6:
            case 9:
            case 11:day = 30;break;
            case 2:
                //判断闰年
                if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
                    day = 29;
                }else {
                    day = 28;
                }
                break;
            default:
                day=0;
                System.out.println("please input correct data");
        }
        System.out.println(day);
    }
}
