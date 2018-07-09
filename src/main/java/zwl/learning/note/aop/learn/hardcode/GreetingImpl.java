package zwl.learning.note.aop.learn.hardcode;

import zwl.learning.note.aop.learn.Greeting;

/**
 * @author zhangwanli
 * @description
 * @date 2018-07-09 下午2:00
 */
public class GreetingImpl implements Greeting {

    @Override
    public void sayHello(String name) {
        before();
        System.out.println("Hello! " + name);
        after();
    }

    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }
}
