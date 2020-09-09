package com.windsoft.demo;

public class Graphics {
    public static void main(String[] args) {
        for(int i = 1; i<=5; i++){
            for (int j = 0; j < i; j++){
                System.out.print('*');
            }
            System.out.println();
        }

        for(int i = 5; i>0; i--){
            for (int j = 0; j < i; j++){
                System.out.print('*');
            }
            System.out.println();
        }

        for(int i = 5; i>0; i--){
            for (int j = 0; j < i; j++){
                System.out.print(' ');
            }
            for(int k=0; k<1+(5-i)*2; k++){
                System.out.print('*');
            }
            System.out.println();
        }

        for(int i = 1; i<=9; i++) {
            for(int y = 1; y <= i; y++) {
                System.out.print(i+"*"+y+"="+i*y+"\t");
            }
            System.out.println();
        }
    }
}
