package com;

import java.util.*;

public class Test {

    public Map testFunction(List<Object> list) {
        return new HashMap();
    }



    public static void main(String[] args) {
        String str = null + "test0";
        System.out.println(str);
    }

    public static void test1(String[] args) {
        System.out.println("");
    }

}

class SubTest extends Test {

    public Map function(List<Object> list) {
        testFunction(null);
        test1(null);
        return null;
    }

    public static void test(String[] args){

    }
}
