package zwl.learning.note.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhangwanli
 * @description
 * @date 2018-10-08 下午3:54
 */
public class LogProxy implements InvocationHandler {

    private Object object;

    public Object getProxyObject(Object o) {
        object = o;

        try {
            return Proxy.newProxyInstance(this.getClass().getClassLoader(), o.getClass().getInterfaces(), this);
        } catch (IllegalArgumentException e) {
            throw  new RuntimeException(e);
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke ...");
        Object result = method.invoke(object, args);
        System.out.println("after invoke ...");
        return result;
    }
}
