package zwl.learning.note.aop.proxy;

import zwl.learning.note.aop.primitive.Dao;
import zwl.learning.note.aop.primitive.DaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhangwanli
 * @description
 * @date 2017-10-23 上午11:26
 */
public class LogInvocationHandler implements InvocationHandler {

    private Object obj;

    public LogInvocationHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        if ("insert".equals(methodName) || "update".equals(methodName)) {
            System.out.println(methodName + "()方法开始时间：" + System.currentTimeMillis());
            Object result = method.invoke(obj, args);
            System.out.println(methodName + "()方法结束时间：" + System.currentTimeMillis());

            return result;
        }

        return method.invoke(obj, args);
    }

    public static void main(String[] args) {
        Dao dao = new DaoImpl();

        Dao proxyDao = (Dao) Proxy.newProxyInstance(LogInvocationHandler.class.getClassLoader(), new Class<?>[]{Dao.class}, new LogInvocationHandler(dao));

        proxyDao.insert();
        System.out.println("----------分割线----------");
        proxyDao.delete();
        System.out.println("----------分割线----------");
        proxyDao.update();
    }

}