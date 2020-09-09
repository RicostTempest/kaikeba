package com.windsoft.demo4;

public class Clothing {
    /**
     * 编号
     */
    private int code;
    /**
     * 名称
     */
    private String name;
    private static int flag;
    static{
        flag = 0;
    }
    {
        flag++;
        code = flag;
    }

    public Clothing(){}
    public Clothing(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println("code:"+code);
    }

}
