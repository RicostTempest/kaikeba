package com.windsoft.demo;

public class Daffodil {
    public static void main(String[] args) {
        int num;
        for(num=100;num<1000;num++){
            int a=num/100;
            int b=num/10%10;
            int c=num%10;
            if(num==a*a*a+b*b*b+c*c*c){
                System.out.println(num);
            }
        }
    }
}
