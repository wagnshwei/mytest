package com;

public class Test2 {

    public static void print(int height){
        for(int i =0; i <height; i ++) {
            for(int j = 0; j < height-i-1;j ++) {
                System.out.print(" ");
            }
            for(int k = 0; k < 2*i+1; k ++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void print0() {
        int n = 5;
        for(int i = 1; i <= n; i ++) {
            for(int j = n-i; j >0; j --) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int height = 5;
//        print(height);
        print0();
    }

}
