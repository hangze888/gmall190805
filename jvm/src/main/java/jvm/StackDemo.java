package jvm;

import java.util.concurrent.TimeUnit;

public class StackDemo {

    public static void main(String[] args) {
        System.out.println("1111");
        test01();
        System.out.println("4444");
    }

    public static void test01(){
        System.out.println("2222");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("3333");
    }
}
