package com.copyutils;

import org.springframework.beans.BeanUtils;

public class Test {

    public static void main(String[] args) {
        A a = new A();
        a.setA("a");
        a.setB("b");
        a.setC("c");

        B b = new B();

        BeanUtils.copyProperties(a,b);
        b.setD("d");

        System.out.println(b);
    }

}

class A {

    private String a;
    private String b;
    private String c;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "A{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                '}';
    }
}

class B extends A {
    private String d;

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    @Override
    public String toString() {
        return "B{" +
                "a='" + this.getA() + '\'' +
                ", b='" + this.getB() + '\'' +
                ", c='" + this.getC() + '\'' +
                ", d='" + d + '\'' +
                '}';
    }
}

