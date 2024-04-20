package com;

import java.util.*;

public class Test {

    public Map function(List<Object> list) {
        return new HashMap();
    }

    public static void main(String[] args) {
        String str = null + "test0";
        System.out.println(str);
    }

}

class SubTest extends Test {
    @Override
    public Map function(List<Object> list) {
        return null;
    }
}