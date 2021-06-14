package zwl.learning.note;

import java.lang.management.ManagementFactory;

/**
 * @author zhangwanli
 * @description
 * @date 2018-10-10 下午2:24
 */
public class Test {

    public void hello(String str ) {
        System.out.println("hello");
    }

    public static void main(String[] args) {
//        Test t = new SubTest();
//        SubTest t1 = (SubTest)t;
        Test t = new Test();
        SubTest t1 = (SubTest)t;
        t1.hello("dd");
    }
}

class SubTest extends Test {
    public void hello(String str ) {
        System.out.println("SubTest");
    }
}
