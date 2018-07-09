package zwl.learning.note.aop.learn.jdkdynamicproxy;

import zwl.learning.note.aop.learn.Greeting;
import zwl.learning.note.aop.learn.GreetingImpl;

/**
 * @author zhangwanli
 * @description
 * @date 2018-07-09 下午2:18
 */
public class Client {

    public static void main(String[] args) {
        Greeting greeting = new JDKDynamicProxy(new GreetingImpl()).getProxy();
        greeting.sayHello("Jack");
    }
}
