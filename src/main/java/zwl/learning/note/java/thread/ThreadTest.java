package zwl.learning.note.java.thread;

/**
 * @author zhangwanli
 * @description
 * @date 2018-07-13 下午4:59
 */
public class ThreadTest {

    public static void main(String[] args) {
        try {
            threadTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void threadTest() throws InterruptedException {
        Thread t = new Thread("ThreadTest") {
            @Override
            public void run() {
                System.out.println("running...");
            }
        };

        println(t);
        t.start();
        println(t);
        Thread.sleep(1000);
        println(t);
    }

    private static void println(Thread t) {
        System.out.println(t.getState().ordinal() + ":" + t.getState());
    }
}
