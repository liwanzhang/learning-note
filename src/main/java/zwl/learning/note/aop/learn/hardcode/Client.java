package zwl.learning.note.aop.learn.hardcode;

import zwl.learning.note.aop.learn.Greeting;

/**
 * @author zhangwanli
 * @description
 * @date 2018-07-09 下午3:38
 */
public class Client {

    public static void main(String[] args) {
        Greeting greeting = new GreetingImpl();
        greeting.sayHello("Jack");
    }


    /*
     * 参考:http://www.importnew.com/21807.html
     *
     * 硬编码,违反“开闭原则”
     *
     * 1.统计每个方法的执行时间，以对性能作出评估;
     *
     */
}
