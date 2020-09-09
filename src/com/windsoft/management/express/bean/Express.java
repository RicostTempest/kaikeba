package com.windsoft.management.express.bean;

import java.util.Objects;

public class Express {
    private String number;
    private String company;
    private int code;

    public Express(){
        code = (int) (Math.random()*9000+1000);
    }
    public Express(String number, String company, int code) {
        this.number = number;
        this.company = company;
        this.code = code;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Express{" +
                "number='" + number + '\'' +
                ", company='" + company + '\'' +
                ", code=" + code +
                '}';
    }

    /**
     * 当快递单号相同时认为是同一快递
     * @param o 被比较的对象
     * @return 是同一对象：true 不是同一类型：false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Express express = (Express) o;
        return Objects.equals(number, express.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
