package zwl.learning.note.aop.demo;

/**
 * @author zhangwanli
 * @description
 * @date 2017-10-24 上午11:47
 */
public class HelloWorldImpl1 implements HelloWorld {
    public void printHelloWorld() {
        System.out.println("Enter HelloWorldImpl1.printHelloWorld()");
    }

    public void doPrint() {
        System.out.println("Enter HelloWorldImpl1.doPrint()");
        return;
    }
}
