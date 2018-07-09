package zwl.learning.note.aop.learn.springaop;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author zhangwanli
 * @description
 * @date 2018-07-09 下午5:48
 */
public class GreetingBeforeAndAfterAdvice implements MethodBeforeAdvice, AfterReturningAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Before");
    }

    @Override
    public void afterReturning(Object result, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("After");
    }
}
