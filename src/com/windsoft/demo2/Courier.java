package com.windsoft.demo2;

import java.util.Scanner;

public class Courier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;
        String[][] courier = new String[20][2];

        while (true) {
            System.out.println("输入身份：1.快递员，2-用户");
            option = scanner.nextInt();
            switch (option){
                case 1:
                    System.out.println("选择操作：1-存快递，2-删除快递，3-修改快递，4-查看所有快递");
                    option = scanner.nextInt();
                    switch (option){
                        case 1:
                            boolean isEmpty = false;
                            for (String[] item:courier) {
                                if (item[0] == null){
                                    isEmpty = true;
                                    System.out.print("请输入快递单号：");
                                    item[0] = scanner.next();
                                    System.out.print("请输入公司名称：");
                                    item[1] = scanner.next();
                                    break;
                                }
                            }
                            if (!isEmpty){
                                System.out.println("仓库已满");
                            }
                            break;
                        case 2:
                            System.out.print("请输入要删除的快递单号：");
                            String num = scanner.next();
                            boolean hasSearch = false;
                            for (String[] item : courier) {
                                if (item[0] != null){
                                    if (item[0].equals(num)){
                                        hasSearch = true;
                                        item[0] = null;
                                        System.out.println("删除成功");
                                    }
                                }
                            }
                            if (!hasSearch){
                                System.out.println("未找到快递");
                            }
                            break;
                        case 3:
                            hasSearch = false;
                            System.out.print("请输入要修改的快递单号：");
                            num = scanner.next();
                            for (String[] item : courier) {
                                if (item[0] != null){
                                    if (item[0].equals(num)){
                                        hasSearch = true;
                                        System.out.print("请输入要新的快递单号：");
                                        item[0]=scanner.next();
                                        System.out.print("请输入要新的快递公司：");
                                        item[1]=scanner.next();
                                    }
                                }
                            }
                            if (!hasSearch){
                                System.out.println("未找到快递");
                            }
                            break;
                        case 4:
                            for (String[] item : courier) {
                                if (item[0] != null){
                                    System.out.println(item[0]+"\t"+item[1]+"\t");
                                }
                            }
                            break;
                    }
                    break;
                case 2:
                    System.out.print("请输入要取件号：");
                    String num = scanner.next();
                    boolean hasSearch = false;
                    for (String[] item : courier) {
                        if (item[0] != null){
                            if (item[0].equals(num)){
                                hasSearch = true;
                                item[0] = null;
                                System.out.println("取件成功");
                            }
                        }
                    }
                    if (!hasSearch){
                        System.out.println("未找到快递");
                    }
                    break;
                default:
            }
        }
    }
}
