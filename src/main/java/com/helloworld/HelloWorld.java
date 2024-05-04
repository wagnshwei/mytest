package com.helloworld;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class HelloWorld {

    public static void main(String[] args) throws ParseException {

        char[] arr0 = new char[]{'a','b'};

        System.out.println(arr0);

        int[] arr1 = new int[]{1,2};

        System.out.println(arr1);

        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        Date date = sdf.parse("Sat Jun 13 00:00:00 CST 2020");

        System.out.println(date);
    }

}
