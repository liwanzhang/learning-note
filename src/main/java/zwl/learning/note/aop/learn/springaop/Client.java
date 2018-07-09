package zwl.learning.note.aop.learn.springaop;

import org.springframework.aop.framework.ProxyFactory;
import zwl.learning.note.aop.learn.Greeting;
import zwl.learning.note.aop.learn.hardcode.GreetingImpl;

/**
 * @author zhangwanli
 * @description
 * @date 2018-07-09 下午2:35
 */
public class Client {

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();     // 创建代理工厂
        proxyFactory.setTarget(new GreetingImpl());         // 射入目标类对象
        proxyFactory.addAdvice(new GreetingBeforeAdvice()); // 添加前置增强
        proxyFactory.addAdvice(new GreetingAfterAdvice());  // 添加后置增强

        Greeting greeting = (Greeting) proxyFactory.getProxy(); // 从代理工厂中获取代理
        greeting.sayHello("Jack");                              // 调用代理的方法
    }
}
