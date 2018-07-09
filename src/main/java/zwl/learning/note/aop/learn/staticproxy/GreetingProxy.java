package zwl.learning.note.aop.learn.staticproxy;

import zwl.learning.note.aop.learn.Greeting;
import zwl.learning.note.aop.learn.GreetingImpl;

/**
 * @author zhangwanli
 * @description
 * @date 2018-07-09 下午2:10
 */
public class GreetingProxy implements Greeting {

    /*
     * 代理模式
     *
     * 问题:Proxy类越来越多,最好只有一个代理类
     */

    private GreetingImpl greetingImpl;

    public GreetingProxy(GreetingImpl greetingImpl) {
        this.greetingImpl = greetingImpl;
    }

    @Override
    public void sayHello(String name) {
        before();
        greetingImpl.sayHello(name);
        after();
    }

    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }
}
