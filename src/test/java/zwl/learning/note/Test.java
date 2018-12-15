package zwl.learning.note;

import java.lang.management.ManagementFactory;

/**
 * @author zhangwanli
 * @description
 * @date 2018-10-10 下午2:24
 */
public class Test {

    public static void main(String[] args) {
        String name = ManagementFactory.getRuntimeMXBean().getName();

        String pid = name.split("@")[0];

        System.out.println(name);
        System.out.println(pid);


        try {
            Thread.sleep(10000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
