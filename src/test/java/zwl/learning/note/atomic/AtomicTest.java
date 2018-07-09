package zwl.learning.note.atomic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangwanli
 * @description
 * @date 2018-06-08 上午10:38
 */
public class AtomicTest {
    public AtomicInteger ai = new AtomicInteger();
    public static int a = 0;

    @Test
    public void atomicTest() {
//        AtomicInteger ai = new AtomicInteger();

        for (int i = 0; i < 100; i++) {
            new Thread() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        ai.getAndIncrement();
                    }
                }
            }.start();
        }

        System.out.println(ai.get());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(ai.get());

    }

    @Test
    public void unatomicTest() {
        Counter c = new Counter();

        for (int i = 0; i < 100; i++) {
            new Thread() {
                @Override
                public void run() {
                    for (int i = 0; i < 100000; i++) {
                        ai.getAndIncrement();
                        a++;
                        c.add();
                    }
                }
            }.start();
        }
        System.out.println(ai.get());
        System.out.println(a);
        System.out.println(c.count);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(ai.get());
        System.out.println(a);
        System.out.println(c.count);
    }

    public class Counter {
        protected int count = 0;

        public void add(){
            count++;
        }
    }

    public class Count {
        public int num = 0;
        public void count() {
            for(int i = 1; i <= 10; i++) {
                num += i;
            }
        }
    }

    public class Count2 {
        private AtomicInteger num = new AtomicInteger();
        public void count() {
            for(int i = 1; i <= 10; i++) {
                num.getAndAdd(i);
            }
        }
    }

    @Test
    public void tTest() {
        Count count = new Count();
        Count2 count2 = new Count2();
        Runnable runnable = new Runnable() {
            public void run() {
                count.count();
                count2.count();
            }
        };
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
        System.out.println(count.num);
        System.out.println(count2.num.get());
    }

}
