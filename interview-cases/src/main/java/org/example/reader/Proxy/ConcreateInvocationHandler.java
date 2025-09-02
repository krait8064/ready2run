package org.example.reader.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ConcreateInvocationHandler implements InvocationHandler {
    private Object target;

    public ConcreateInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("InvocationHandler invoked " + target.toString());
        return method.invoke(this.target, args);
    }
}
