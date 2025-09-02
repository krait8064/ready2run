package org.example.reader.multi.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * created by krait8064 at 2019/11/18
 */
public class ConPrintTest {
    private static Lock lock = new ReentrantLock();
    private static Condition A = lock.newCondition();
    private static Condition B = lock.newCondition();
    private static Condition C = lock.newCondition();
    private static List<Condition> conditions = Arrays.asList(A, B, C);

    private static int count = 0;

    static class ThreadA extends Thread {
        private Condition cur;
        private Condition next;
        private Lock lock;
        private int times;
        private List<String> names;
        private String name;

        public ThreadA(Condition cur, Condition next, Lock lock, int times, List<String> names, String name) {
            this.cur = cur;
            this.next = next;
            this.lock = lock;
            this.times = times;
            this.names = names;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < times; i++) {
                    while (count % names.size() != names.indexOf(name))//注意这里是不等于0，也就是说在count % 3为0之前，当前线程一直阻塞状态
                        cur.await(); // A释放lock锁
                    System.out.print(name);
                    count++;
                    next.signal(); // A执行完唤醒B线程
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        List<String> names = Arrays.asList("A", "B", "C");
        for (String name : names) {
            new ThreadA(conditions.get(names.indexOf(name)), conditions.get((names.indexOf(name) + 1) % names.size()), lock, 10, names, name).start();
        }
    }
}
