package com.windsoft.demo;

import java.util.Date;
import java.util.Scanner;

public class TAXI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mileage; //里程
        boolean empty;
        int time; //乘车时间
        boolean order; //预约
        boolean orderTime; //预约时长
        boolean lowSpeedDriving; //低速行驶
        int peakLowTime; //低速行驶时长
        int normalLowTime;
        boolean night; //是否夜间行车

        float mileageCharge;
        float lowSpeedCharge;
        float orderCharge;
        float nightCharge;
        float sum;

        System.out.println("Please input the mileage /km:");
        mileage = scanner.nextInt();
        if (mileage < 3){
            mileageCharge = 13;
        }else if (mileage > 15){
            System.out.println("Does the round trip exceed 2 kilometers? 1.yes,2.no");
            empty = scanner.nextInt() == 1;
            if (empty) {
                mileageCharge = (float) ((15*2.3) + (mileage-15)*2.3*1.5);
            }else {
                mileageCharge = (float) (mileage*2.3);
            }
        }else {
            mileageCharge = (float) (mileage*2.3);
        }
        System.out.println("Please input the driving time /min");
        time = scanner.nextInt();
        System.out.println("Whether reservation order? 1.yes,2.no");
        order = scanner.nextInt() == 1;
        if (order){
            System.out.println("Whether more than 4 hours? 1.yes,2.no");
            orderTime = scanner.nextInt() == 1;
            if (orderTime) {
                orderCharge = 6;
            }else {
                orderCharge = 5;
            }
        }else {
            orderCharge = 0;
        }
        System.out.println("Whether to travel at low speed? 1.yes,2.no");
        lowSpeedDriving = scanner.nextInt() == 1;
        if (lowSpeedDriving) {
            System.out.println("Please input the time of low speed in peak /min");
            peakLowTime = scanner.nextInt();
            System.out.println("Please input the time of low speed in normal /min");
            normalLowTime = scanner.nextInt();
            lowSpeedCharge = (peakLowTime/5)*2*2.3f + (normalLowTime/5)*2.3f;
        }else {
            lowSpeedCharge = 0;
        }
        System.out.println("Whether driving at night? 1.yes,2.no");
        night = scanner.nextInt() == 1;
        if (night){
            nightCharge = (mileageCharge + lowSpeedCharge)*0.2f;
        }else {
            nightCharge = 0;
        }

        sum = mileageCharge+lowSpeedCharge+nightCharge+orderCharge+1;
        System.out.println("sum:"+Math.round(sum));
        System.out.println("mileage charge:"+mileageCharge);
        System.out.println("low speed charge:"+lowSpeedCharge);
        System.out.println("order charge:"+orderCharge);
        System.out.println("night charge:"+nightCharge);
        System.out.println("extra charge:1");
    }
}
