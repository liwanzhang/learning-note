package zwl.learning.note.java.polymorphic;

/**
 * @author zhangwanli
 * @description
 * @date 2018-08-14 下午4:06
 */
public class Covariant {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        A b = new B();
        b.getC().print();

        A a = new A();
        a.getC().print();
    }

}

class A{
    public C getC() {
        return new C();
    }
}

class B extends A{
//    public D getC(){
//        return new D();
//    }
//    public E getC(){
//        return new E();
//    }
}

class C{
    public void print(){
        System.out.println("C");
    }
}

class D extends C{
    public void print(){
        System.out.println("D");
    }
}

class E{
    public void print(){
        System.out.println("E");
    }
}

class F{
    public void print(){
        System.out.println("F");
    }
}
