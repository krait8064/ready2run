package org.example.reader.multi.thread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * created by krait8064 at 2019/11/20
 */
public class FutureTest {
    @Test
    public void test() {
        int size = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Callable<String>> exes = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            final int sec = i;
            exes.add(new StringFuture(sec));
        }
        try {
            List<Future<String>> futures = executorService.invokeAll(exes);
            int count = 0;
            while (true && count <= 10000) {
                for (Future<String> future : futures) {
                    if (future.isDone()) {
                        String s = future.get();
                        System.out.println("the " + count + " print get result:" + s);
                    }
                }
                Thread.sleep(1);
                count++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    static class StringFuture implements Callable<String> {
        private int size;

        public StringFuture(int size) {
            this.size = size;
        }

        @Override
        public String call() throws Exception {
            Thread.sleep(size * 100);
            return String.valueOf(size);
        }
    }
}
