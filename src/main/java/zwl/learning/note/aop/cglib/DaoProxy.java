package zwl.learning.note.aop.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import zwl.learning.note.aop.primitive.Dao;
import zwl.learning.note.aop.primitive.DaoImpl;

import java.lang.reflect.Method;

/**
 * @author zhangwanli
 * @description
 * @date 2017-10-23 上午11:29
 */
public class DaoProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy proxy) throws Throwable {
        String methodName = method.getName();

        if ("insert".equals(methodName) || "update".equals(methodName)) {
            System.out.println(methodName + "()方法开始时间：" + System.currentTimeMillis());
            proxy.invokeSuper(object, objects);
            System.out.println(methodName + "()方法结束时间：" + System.currentTimeMillis());

            return object;
        }

        proxy.invokeSuper(object, objects);
        return object;
    }

    public static void main(String[] args) {
        DaoProxy daoProxy = new DaoProxy();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(DaoImpl.class);
        enhancer.setCallback(daoProxy);

        Dao dao = (DaoImpl)enhancer.create();
        dao.insert();
        System.out.println("----------分割线----------");
        dao.delete();
        System.out.println("----------分割线----------");
        dao.update();
    }

}
