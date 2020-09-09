package com.windsoft.demo3;

public class Employee {
    private String name;
    private String code;
    private float basicSalary;
    private float salaryIncreaseRat;

    public float getSalaryGrowth(){
        return basicSalary * salaryIncreaseRat;
    }

    public float getAfterGrowthSalary(){
        return basicSalary * (1 + salaryIncreaseRat);
    }
}
