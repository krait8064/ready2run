package org.example.reader;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * created by krait8064 at 2020/07/02
 */
public class DateTimeFormatterTest {
    @Test
    public void test() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("");
        String format = dateTimeFormatter.format(localDateTime);
    }
}
