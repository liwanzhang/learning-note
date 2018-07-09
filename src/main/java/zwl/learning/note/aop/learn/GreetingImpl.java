package zwl.learning.note.aop.learn;

/**
 * @author zhangwanli
 * @description
 * @date 2018-07-09 下午3:33
 */
public class GreetingImpl implements Greeting {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello! " + name);
    }
}
