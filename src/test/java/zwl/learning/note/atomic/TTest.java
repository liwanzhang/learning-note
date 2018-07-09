package zwl.learning.note.atomic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangwanli
 * @description
 * @date 2018-06-08 上午11:23
 */
public class TTest {

    private AtomicInteger atomicI = new AtomicInteger(0);
    private AtomicInteger atomicI2 = new AtomicInteger(0);
    private AtomicInteger atomicI3 = new AtomicInteger(0);

    private int i = 0;

    public static void main(String[] args) {
        final TTest cas = new TTest();
        List<Thread> ts = new ArrayList(600);
        long start = System.currentTimeMillis();
        for (int j = 0; j < 100; j++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100000; i++) {
                        cas.count();
                        cas.safeCount();
                        cas.safeCount2();
                        cas.safeCount3();
                    }
                }
            });
            ts.add(t);
        }
        for (Thread t : ts) {
            t.start();
        }
        // 等待所有线程执行完成
        for (Thread t : ts) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(cas.i);
        System.out.println(cas.atomicI.get());
        System.out.println(cas.atomicI2.get());
        System.out.println(cas.atomicI3.get());
        System.out.println(System.currentTimeMillis() - start);
    }



    private void safeCount() {
        for (; ; ) {
            int i = atomicI.get();
            boolean suc = atomicI.compareAndSet(i, ++i);
            if (suc) {
                break;
            }
        }
    }

    private void safeCount3() {
        atomicI3.getAndAdd(1);
    }

    private void safeCount2() {
        atomicI2.getAndIncrement();
    }


    private void count() {
        i++;
    }

}


