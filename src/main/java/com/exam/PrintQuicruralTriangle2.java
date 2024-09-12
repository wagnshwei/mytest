package com.exam;

public class PrintQuicruralTriangle2 {

    public static void main(String[] args) {
        for(int i = 0; i < 3; i ++) {
            for(int j = 2-i; j > 0; j --) {
                System.out.print(" ");
            }
            for(int k = 0; k < 2*i+1; k ++) {
                System.out.print("*");
            }
            System.out.print("\r\n");
        }
    }

}
