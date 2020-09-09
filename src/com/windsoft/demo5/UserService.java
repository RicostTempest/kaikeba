package com.windsoft.demo5;

import java.util.Scanner;

public class UserService {
    /**
     * 输入正确性判断
     * @param user 账户信息
     * @return 判定结果
     */
    public boolean login(User user){
        if (!user.getAccount().equals("admin")){
            return false;
        }else{
            return user.getPassword().equals("123");
        }
    }

    /**
     * 获取用户输入
     */
    public void scanner(){
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        System.out.print("input you account:");
        user.setAccount(scanner.next());
        System.out.print("input you password:");
        user.setPassword(scanner.next());

        System.out.println(login(user) ? "登录成功" : "帐号或密码错误" );
    }
}
