package zwl.learning.note.aop.demo;

/**
 * @author zhangwanli
 * @description
 * @date 2017-10-24 上午11:48
 */
public class HelloWorldImpl2 implements HelloWorld {
    public void printHelloWorld() {
        System.out.println("Enter HelloWorldImpl2.printHelloWorld()");
    }

    public void doPrint() {
        System.out.println("Enter HelloWorldImpl2.doPrint()");
        return;
    }
}
