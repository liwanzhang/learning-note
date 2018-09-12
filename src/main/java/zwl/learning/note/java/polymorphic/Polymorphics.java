package zwl.learning.note.java.polymorphic;

/**
 * @author zhangwanli
 * @description
 * @date 2018-08-14 下午3:40
 */
public class Polymorphics {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Super sup = new Sub();
        System.out.println("sup.field = " + sup.field + ", sup.getField() = " + sup.getField());
        Sub sub = new Sub();
        System.out.println("sub.field = " + sub.field + ", sub.getField() = " + sub.getField() + ", sub.getSuperField() = " + sub.getSuperField());
    }
}
