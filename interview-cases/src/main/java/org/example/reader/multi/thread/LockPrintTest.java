package org.example.reader.multi.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * created by krait8064 at 2019/11/18
 */
public class LockPrintTest {
    private static Lock lock = new ReentrantLock();// 通过JDK5中的Lock锁来保证线程的访问的互斥
    private static int state = 0;//通过state的值来确定是否打印

    static class ThreadA extends Thread {
        private int time;
        private List<String> name;
        private int index;

        public ThreadA(int time, List<String> name, int index) {
            this.time = time;
            this.name = name;
            this.index = index;
        }

        @Override
        public void run() {
            for (int i = 0; i < time; ) {
                try {
                    lock.lock();
                    while (state % name.size() == index) {// 多线程并发，不能用if，必须用循环测试等待条件，避免虚假唤醒
                        System.out.print(name.get(index));
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock();// unlock()操作必须放在finally块中
                }
            }
        }
    }


    public static void main(String[] args) {

        List<String> names = Arrays.asList("A", "B", "C");
        for (String name : names) {
            new ThreadA(10, names, names.indexOf(name)).start();
        }
    }
}
