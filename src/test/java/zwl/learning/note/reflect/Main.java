package zwl.learning.note.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhangwanli
 * @description
 * @date 2018-09-10 上午11:48
 */
public class Main {
    public static void main(String[] args) {


        try {
            long now;
            long sum = 0;
            TestClass t = new TestClass();

            now = System.currentTimeMillis();

            for(int i = 0; i<500000; ++i){
                t.setNum(i);
                sum += t.getNum();
            }

            System.out.println("get-set耗时"+(System.currentTimeMillis() - now) + "ms秒，和是" +sum);

            sum = 0;
            now = System.currentTimeMillis();

            for(int i = 0; i<500000; ++i){
                Class<?> c = Class.forName("zwl.learning.note.reflect.TestClass");
                Class<?>[] argsType = new Class[1];
                argsType[0] = int.class;
                Method m = c.getMethod("setNum", argsType);
                m.invoke(t, i);
                sum += t.getNum();
            }
            System.out.println("标准反射耗时"+(System.currentTimeMillis() - now) + "ms，和是" +sum);

            sum = 0;

            Class<?> c = Class.forName("zwl.learning.note.reflect.TestClass");
            Class<?>[] argsType = new Class[1];
            argsType[0] = int.class;
            Method m = c.getMethod("setNum", argsType);

            now = System.currentTimeMillis();

            for(int i = 0; i<500000; ++i){
                m.invoke(t, i);
                sum += t.getNum();
            }
            System.out.println("缓存反射耗时"+(System.currentTimeMillis() - now) + "ms，和是" +sum);

            sum = 0;
            now = System.currentTimeMillis();

//        MethodAccess ma = MethodAccess.get(TestClass.class);
//        int index = ma.getIndex("setNum");
//
//        for(int i = 0; i<500000; ++i){
//            ma.invoke(t, index, i);
//            sum += t.getNum();
//        }
//        System.out.println("reflectasm反射耗时"+(System.currentTimeMillis() - now) + "ms，和是" +sum);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
