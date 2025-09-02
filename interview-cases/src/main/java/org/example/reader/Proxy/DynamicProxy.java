package org.example.reader.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxy<T> {
    public static <T> T invoke(ClassLoader cl, Class<?>[] interfaces, InvocationHandler handler) {
        System.out.println("DynamicProxy invoked");
        if (true) {
            new SAdvice().doBefore();
        }
        return (T) Proxy.newProxyInstance(cl, interfaces, handler);
    }
}
