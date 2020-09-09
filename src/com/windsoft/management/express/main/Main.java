package com.windsoft.management.express.main;

import com.windsoft.management.express.bean.Express;
import com.windsoft.management.express.dao.ExpressDao;
import com.windsoft.management.express.view.Views;

public class Main {
    static Views views = new Views();
    static ExpressDao dao = new ExpressDao();
    public static void main(String[] args) {
        views.welcome();
        while (true){
            switch (views.menu()){
                case 1:
                    cMain();
                    continue;
                case 2 :
                    uMain();
                    continue;
                case 0:break;
            }
            break;
        }
    }

    public static void cMain(){
        while (true){
            switch (views.cMenu()){
                case 1:
                    dao.add(views.insert());
                    continue;
                case 2 :
                    dao.update(dao.findByNumber(views.findByNumber()),views.update());
                    continue;
                case 3:
                    Express express = dao.findByNumber(views.findByNumber());
                    if (express != null){
                        dao.delete(express);
                        System.out.println("删除成功");
                    }else{
                        System.out.println("快递不存在");
                    }
                    continue;
                case 4:
                    views.printAll(dao.findAll());
                    continue;
                case 0:break;
            }
            break;
        }
    }

    public static void uMain(){
        Express express = dao.findByCode(views.uMenu());
        if (express != null){
            dao.delete(express);
            System.out.println("取件成功");
        }else{
            System.out.println("快递不存在");
        }
    }
}
