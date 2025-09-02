package org.example.reader.jvm;

import java.util.ArrayList;
import java.util.List;

public class OOMTest {
    static class OOM {
    }

    public static void main(String[] args) {
        //-XX:+HeapDumpOnOutOfMemoryError -Xms1m -Xmx2m
        List<OOM> list = new ArrayList<>();
        while (true) {
            list.add(new OOM());
        }
    }
}
