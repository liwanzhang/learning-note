package zwl.learning.note.aop.learn;

import org.springframework.stereotype.Component;

/**
 * @author zhangwanli
 * @description
 * @date 2018-07-09 下午3:33
 */
@Component
public class GreetingImpl implements Greeting {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello! " + name);
        throw new RuntimeException("Error"); // 故意抛出一个异常，看看异常信息能否被拦截到
    }

//    @Override
//    public void sayHelloThrowException(String name) {
//        System.out.println("Hello! " + name);
//        throw new RuntimeException("Error"); // 故意抛出一个异常，看看异常信息能否被拦截到
//    }
}
