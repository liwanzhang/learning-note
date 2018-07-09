package zwl.learning.note.aop.learn.springaop;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zwl.learning.note.aop.learn.Apology;
import zwl.learning.note.aop.learn.Greeting;
import zwl.learning.note.aop.learn.GreetingImpl;

/**
 * @author zhangwanli
 * @description
 * @date 2018-07-09 下午2:35
 */
public class Client {

//    public static void main(String[] args) {
//        ProxyFactory proxyFactory = new ProxyFactory();     // 创建代理工厂
//        proxyFactory.setTarget(new GreetingImpl());         // 设置目标对象
////        proxyFactory.addAdvice(new GreetingBeforeAdvice()); // 添加前置增强
////        proxyFactory.addAdvice(new GreetingAfterAdvice());  // 添加后置增强
//
////        proxyFactory.addAdvice(new GreetingBeforeAndAfterAdvice());
//
//        proxyFactory.addAdvice(new GreetingAroundAdvice()); // 设置环绕增强
//
//        Greeting greeting = (Greeting) proxyFactory.getProxy(); // 从代理工厂中获取代理
//        greeting.sayHello("Jack");                              // 调用代理的方法
//    }

    // 声明式使用
//    public static void main(String[] args) {
//        String s[] = System.getProperty("java.class.path").split(";");
//        for (String string : s) {
//            System.out.println(string);
//        }
//
//        ApplicationContext context = new ClassPathXmlApplicationContext("zwl/learning/note/aop/learn/springaop/spring-aop.xml"); // 获取 Spring Context
//        Greeting greeting = (Greeting) context.getBean("greetingProxy");                        // 从 Context 中根据 id 获取 Bean 对象（其实就是一个代理）
//        greeting.sayHello("Jack");                                                              // 调用代理的方法
//    }

    // 抛出增强
//    public static void main(String[] args) {
//
//        ApplicationContext context = new ClassPathXmlApplicationContext("zwl/learning/note/aop/learn/springaop/spring-aop.xml"); // 获取 Spring Context
//        Greeting greeting = (Greeting) context.getBean("greetingProxy");                        // 从 Context 中根据 id 获取 Bean 对象（其实就是一个代理）
//        greeting.sayHello("Jack");                                                              // 调用代理的方法
//    }

    // 引入增强
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("zwl/learning/note/aop/learn/springaop/spring-aop.xml"); // 获取 Spring Context
        Greeting greeting = (Greeting) context.getBean("greetingIntroProxy");                        // 从 Context 中根据 id 获取 Bean 对象（其实就是一个代理）
//        greeting.sayHello("Jack");                                                              // 调用代理的方法

        Apology apology = (Apology) greeting; // 将目标类强制向上转型为 Apology 接口（这是引入增强给我们带来的特性，也就是“接口动态实现”功能）
        apology.saySorry("Jack");
    }
}
