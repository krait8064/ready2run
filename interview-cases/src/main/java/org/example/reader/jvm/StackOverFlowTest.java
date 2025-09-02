package org.example.reader.jvm;

import org.junit.Test;

/**
 * created by krait8064 at 2019/11/20
 */
public class StackOverFlowTest {
    private int len = 1;

    // -Xss128k，不加参数也会如此
    @Test
    public void test() {
        stackLeak();
    }

    public void stackLeak() {
        len++;
        stackLeak();
    }
}
