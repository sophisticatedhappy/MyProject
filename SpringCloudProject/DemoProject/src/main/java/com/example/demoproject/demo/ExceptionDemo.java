package com.example.demoproject.demo;

public class ExceptionDemo {

    public static void main(String[] args) {

        int res = exceptionDemo();
        System.out.println("res:"+ res);
    }
    public static int exceptionDemo(){
        int a = 6;
        int b = 0;
        try {
            System.out.println(a/b);
            return 99;
        }catch (ArithmeticException e){
            System.out.println("catch捕获到了异常");
            e.printStackTrace();
            return 1 ;
        }finally {
            System.out.println("finnally执行了");
            return 2;
        }
    }
}
