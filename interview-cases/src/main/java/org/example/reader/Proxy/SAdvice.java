package org.example.reader.Proxy;

public class SAdvice implements Advice {

    @Override
    public void doBefore() {
        System.out.println("advice called");
    }
}
