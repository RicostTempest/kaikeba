package com.windsoft.demo4;

public class Student {
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;
    /**
     * 性别
     */
    private String sex;
    /**
     * 爱好
     */
    private String hobby;
    /**
     * 公司
     */
    private static String company;
    /**
     * 学科
     */
    private static String subject;
    static{
        company = "开课吧";
        company = "Java";
    }

    public Student(){}
    public Student(String name, int age, String sex, String hobby) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public static String getCompany() {
        return company;
    }

    public static void setCompany(String company) {
        Student.company = company;
    }

    public static String getSubject() {
        return subject;
    }

    public static void setSubject(String subject) {
        Student.subject = subject;
    }

    public void test(int... nums){
        System.out.println(nums.getClass());
    }
}
