package org.example.reader;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * created by krait8064 at 2019/12/17
 */
public class MapKeyTest {
    @Test
    public void mapTest() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(null, -1);
        map.put(null, -2);
        map.put(1, 1);
        map.put(2, 2);
    }
}
