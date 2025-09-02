package org.example.reader.jvm;

import org.junit.Test;

/**
 * created by krait8064 at 2019/11/20
 */
public class ConstantPoolTest {
    @Test
    public void test() {
        String a = "hello";
        String b = a.intern();
        String c = a.intern();
        System.out.println(String.format("a:%s,b:%s,c:%s", a, b, c));
        a = a.substring(2);
        System.out.println(String.format("a:%s,b:%s,c:%s", a, b, c));
    }

}
