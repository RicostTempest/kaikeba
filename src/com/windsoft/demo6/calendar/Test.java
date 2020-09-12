package com.windsoft.demo6.calendar;

import java.util.Calendar;
import java.util.Scanner;

/**
 * @Description: 休息日历
 * @Author: Ricost
 * @Date: 2020/9/10
*/
public class Test {
    public static void main(String[] args) {
        Calendar start = Calendar.getInstance();
        Calendar search = Calendar.getInstance();
        int count = 0,count2 = 0;
        int year,month;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年：");
        year = scanner.nextInt();
        System.out.println("请输入月：");
        month = scanner.nextInt();
        start.set(2020, Calendar.FEBRUARY,2);
        search.set(year, month-1,1);
        System.out.println((search.get(Calendar.DAY_OF_YEAR) - start.get(Calendar.DAY_OF_YEAR))%4);
        System.out.println("星期日\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六\t");
        for (int i = 1; i < search.get(Calendar.DAY_OF_WEEK); i++){
            System.out.print("\t\t");
        }

        while (search.get(Calendar.DATE) <= search.getActualMaximum(Calendar.DAY_OF_MONTH) && search.get(Calendar.MONTH) == 1){
            if ((search.get(Calendar.DAY_OF_YEAR) - start.get(Calendar.DAY_OF_YEAR))%4 != 0){
                System.out.print(search.get(Calendar.DATE) + "\t\t");
            }else{
                System.out.print("["+search.get(Calendar.DATE)+ "]"+"\t\t");
                count++;
                if (search.get(Calendar.DAY_OF_WEEK)==7 || search.get(Calendar.DAY_OF_WEEK)==1){
                    count2++;
                }
            }
            if (search.get(Calendar.DAY_OF_WEEK) % 7 == 0){
                System.out.print("\n");
            }
            search.add(Calendar.DATE,1);
        }
        System.out.println("本月休息天数有：" + count);
        System.out.println("本月轮到周末休息的天数有："+count2);
    }
}
