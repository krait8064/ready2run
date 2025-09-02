package org.example.reader.Proxy;

public class Client {
    public static void main(String[] args) {
        Subject sub = new ConcreateSubject("id17");
        Subject proxy = ConcreateProxy.newProxyInstance(sub);
        proxy.doSth();
    }
}
