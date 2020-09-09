package com.windsoft.management.express.view;

import com.windsoft.management.express.bean.Express;

import java.util.Scanner;

/**
 * 视图层
 *  显示对应的提示信息
 */
public class Views {
    public Scanner input = new Scanner(System.in);

    /**
     * 欢迎界面
     */
    public void welcome(){
        System.out.println("欢迎使用WINDSOFT快递管理系统");
    }

    /**
     * 退出界面
     */
    public void bye(){
        System.out.println("谢谢使用");
    }
    /**
     * 开始菜单
     * @return 选择选项
     */
    public int menu(){
        System.out.println("选择身份进入系统");
        System.out.println("1.快递员");
        System.out.println("2.普通用户");
        System.out.println("0.退出");
        String text = input.nextLine();
        int num = -1;
        try {
            num = Integer.parseInt(text);
        }catch (NumberFormatException e){

        }
        if (num < 0 || num > 2)
            return menu();
        return num;
    }
    /**
     * 快递员菜单
     * @return 选择选项
     */
    public int cMenu(){
        System.out.println("选择功能");
        System.out.println("1.快递录入");
        System.out.println("2.快递修改");
        System.out.println("3.快递删除");
        System.out.println("4.查看所有快递");
        System.out.println("0.退出");
        String text = input.nextLine();
        int num = -1;
        try {
            num = Integer.parseInt(text);
        }catch (NumberFormatException e){

        }
        if (num < 0 || num > 4)
            return cMenu();
        return num;
    }

    /**
     * 添加快递
     * @return 新建的Express对象
     */
    public Express insert(){
        System.out.println("输入快递单号：");
        String number = input.nextLine();
        System.out.println("输入快递公司：");
        String company = input.nextLine();
        Express express = new Express(number,company,1);
        return express;
    }

    /**
     * 查找快递
     * @return 查询成功的快递单号
     */
    public String findByNumber(){
        System.out.print("输入快递单号：");
        String number = input.nextLine();
        return number;
    }
    /**
     * 修改快递信息
     * @return 全新输入的对象修改的快递对象
     */
    public Express update(){
        Express express = new Express();
        System.out.println("输入新的快递单号：");
        String company = input.nextLine();
        System.out.println("输入新的快递公司：");
        express.setCompany(company);
        String number = input.nextLine();
        express.setNumber(number);
        return express;
    }

    /**
     * 删除操作
     * @return true：确认删除，false：取消操作
     */
    public boolean delete(){
        System.out.println("是否删除：");
        System.out.println("1.确认删除");
        System.out.println("2.取消操作");
        String text = input.nextLine();
        int num = -1;
        try {
            num = Integer.parseInt(text);
        }catch (NumberFormatException e){

        }
        if (num < 1 || num > 2)
            return delete();
        return num==1;
    }

    /**
     * 打印所有快递信息
     * @param expresses 全部快递
     */
    public void printAll(Express[] expresses){
        if (expresses == null || expresses.length == 0){
            System.out.println("快递库为空");
        }
        for (int i=0; i < expresses.length; i++){
            if(expresses[i] != null)
                printExpress(expresses[i]);
        }
    }
    public void printExpress(Express express){
        System.out.println("快递公司："+ express.getCompany()+"快递单号："+express.getNumber());
    }
    /**
     * 快递员菜单
     * @return 选择选项
     */
    public int uMenu(){
        System.out.println("选择功能");
        System.out.println("请输入取件号：");
        String code = input.nextLine();
        int num = -1;
        try {
            num = Integer.parseInt(code);
        }catch (NumberFormatException e){

        }
        if (num < 0 || num > 4)
            return cMenu();
        return num;
    }
}
