package zwl.learning.note.aop.learn.springaop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author zhangwanli
 * @description
 * @date 2018-07-09 下午2:36
 */
public class GreetingAfterAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object result, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("After");
    }
}
