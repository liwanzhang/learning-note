package zwl.learning.note.aop.learn.springaop;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import org.springframework.stereotype.Component;
import zwl.learning.note.aop.learn.Apology;

/**
 * @author zhangwanli
 * @description
 * @date 2018-07-09 下午6:31
 */
@Component
public class GreetingIntroAdvice extends DelegatingIntroductionInterceptor implements Apology {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        return super.invoke(invocation);
    }

    @Override
    public void saySorry(String name) {
        System.out.println("Sorry! " + name);
    }
}
