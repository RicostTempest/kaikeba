package com.windsoft.demo;

import java.util.Scanner;

public class AI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //声明变量
        String question;
        while (true){
            //获取键盘输入
            question = scanner.next();
            //将输入的字符串中的“吗”去掉
            question = question.replace("吗","");
            //将输入的字符串中的“我”换成“我也”
            question = question.replace("我","我也");
            //将输入的字符串中的“？”换成“！”
            question = question.replace("？","！");
            //输出替换完的字符串
            System.out.println(question);

        }
    }
}
