package com;

class Super {
    public Integer getLen() {
        return new Integer(4);
    }
}

public class Sub extends Super {
    public Integer getLen() {
        return new Integer(5);
    }
    public static void main(String[] args) {
        System.out.println(new Super().getLen().toString() + "," + new Sub().getLen().toString() );
    }
}
