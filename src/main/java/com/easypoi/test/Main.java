package com.easypoi.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface MyInterface {
    void doSomething();
}

class MyInterfaceImpl implements MyInterface {
    public void doSomething() {
        System.out.println("Doing something");
    }
}

class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before method call");
        Object result = method.invoke(target, args);
        System.out.println("After method call");
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        MyInterface original = new MyInterfaceImpl();
        MyInterface myInterface = (MyInterface) Proxy.newProxyInstance(
                MyInterface.class.getClassLoader(),
                new Class[] { MyInterface.class },
                new MyInvocationHandler(original)
        );

        myInterface.doSomething();
    }
}