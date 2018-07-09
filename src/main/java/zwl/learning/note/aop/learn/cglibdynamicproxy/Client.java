package zwl.learning.note.aop.learn.cglibdynamicproxy;

import zwl.learning.note.aop.learn.Greeting;
import zwl.learning.note.aop.learn.GreetingImpl;

/**
 * @author zhangwanli
 * @description
 * @date 2018-07-09 下午2:22
 */
public class Client {

    public static void main(String[] args) {
        Greeting greeting = CGLibDynamicProxy.getInstance().getProxy(GreetingImpl.class);
        greeting.sayHello("Jack");
    }
}
