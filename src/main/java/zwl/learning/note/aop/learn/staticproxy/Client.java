package zwl.learning.note.aop.learn.staticproxy;

import zwl.learning.note.aop.learn.Greeting;
import zwl.learning.note.aop.learn.GreetingImpl;

/**
 * @author zhangwanli
 * @description
 * @date 2018-07-09 下午2:13
 */
public class Client {

    public static void main(String[] args) {
        Greeting greetingProxy = new GreetingProxy(new GreetingImpl());
        greetingProxy.sayHello("Jack");
    }
}
