package org.example.reader.Proxy;

public class ConcreateSubject implements Subject {

    private String id;

    public ConcreateSubject(String id) {
        this.id = id;
    }

    @Override
    public void doSth() {

    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "sub " + id + " invoked";
    }
}
