package org.example.reader.Proxy;

import java.lang.reflect.InvocationHandler;

public class ConcreateProxy extends DynamicProxy {
    public static <T> T newProxyInstance(Subject sub) {
        ClassLoader classLoader = sub.getClass().getClassLoader();
        Class<?>[] interfaces = sub.getClass().getInterfaces();
        InvocationHandler handler = new ConcreateInvocationHandler(sub);
        System.out.println("concurrent proxy constructing " + sub.getId());
        return invoke(classLoader, interfaces, handler);
    }
}
