package org.example.reader.jvm;

import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * created by krait8064 at 2019/11/20
 */
public class DirectMemoryTest {
    private static final int MB = 1024 ^ 1024;

    // -Xmx2M -XX:MaxDirectMemorySize=1M，验证无效
    @Test
    public void test() {
        Field field = Unsafe.class.getDeclaredFields()[0];
        field.setAccessible(true);
        Unsafe unsafe = null;
        try {
            unsafe = (Unsafe) field.get(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        while (true) {
            unsafe.allocateMemory(MB);
        }
    }
}
