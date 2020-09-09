package com.windsoft.demo5;

import java.util.Scanner;

/**
 * 1.剪刀 2.石头 3.布
 *
 */
public class FingerGuessingMachine {
    //机器人胜场
    private int win;
    //机器人败场
    private int lose;
    private String name;
    //用户输入
    private int[] person;
    //机器人输入
    private int[] computer;

    public FingerGuessingMachine(String name, int i) {
        lose = win = 0;
        this.name = name;
        person = new int[i];
        computer = new int[i];
        start(i);
    }

    /**
     * 输入值进行比较
     * @param i 数组下标
     * @return int，1.win 2.lost 3.dogfall
     */
    public int compare(int i){
        switch (person[i] - computer[i]) {
            case 0 : return 3;
            case 1 :
            case -2 :
                win++; return 1;
            case -1 :
            case  2 :
                lose++; return 2;
        }
        return 0;
    }
    /**
     * 出拳
     * @param i 数组下标
     */
    public void throwPunch(int i){
        Scanner scanner = new Scanner(System.in);
        System.out.println("出拳：（1.剪刀 2.石头 3.布）");
        person[i] = scanner.nextInt();
        computer[i] = (int) (Math.random()*3 +1);
    }

    /**
     * 提示文字
     */
    public void hint(int i){
        switch (compare(i)){
            case 1:
                System.out.println("you win"); break;
            case 2:
                System.out.println("you lose"); break;
            case 3:
                System.out.println("dogfall");
        }
    }

    public void start(int count){
        System.out.println("Game Start");
        for (int i=0; i < count; i++){
            System.out.println("第"+(i+1)+"场，剩余："+(count-i+1));
            throwPunch(i);
            hint(i);
        }
        if (win == lose){
            System.out.println("dogfall");
        } else if (win > lose) {
            System.out.println("you lose");
        }else {
            System.out.println("you win");
        }
        System.out.println("场次结束积分："+this.name + ":"+win+";you："+lose);
    }
}
