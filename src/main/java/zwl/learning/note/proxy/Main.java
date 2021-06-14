//package zwl.learning.note.proxy;
//
//import com.sun.tools.attach.AttachNotSupportedException;
//import com.sun.tools.attach.VirtualMachine;
//
//import java.io.IOException;
//
///**
// * @author zhangwanli
// * @description
// * @date 2018-10-08 下午4:00
// */
//public class Main {
//    public static void main(String[] args) {
//        LogProxy logProxy = new LogProxy();
////        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
//        HelloWorldInteface helloWorldInteface = (HelloWorldInteface) logProxy.getProxyObject(new HelloWorldImpl());
//        helloWorldInteface.sayHello();
//
//        try {
//            VirtualMachine vm = VirtualMachine.attach(args[0]);
//        } catch (AttachNotSupportedException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//}
