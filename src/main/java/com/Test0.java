package com;

public class Test0 {


    public static void main(String[] args) {
//        int a = 2;
//        a += a -= a * a;
//        System.out.println(a);

        char arr[] = {'a','b','c'};

        String str = new String(arr);
        System.out.println(str);

        createThread(()-> {
            System.out.println("A开始执行");
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("A执行结束");
        });
        createThread(()-> {
            System.out.println("B开始执行");
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B执行结束");
        });
        createThread(()-> {
            System.out.println("C开始执行");
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("C执行结束");
        });

    }

    public static void createThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.start();
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
