package zwl.learning.note.java.instance.polymorphic;

/**
 * @author zhangwanli
 * @description
 * @date 2018-07-17 下午4:19
 */
public class StaticPolymorphism {

    public static void main(String[] args) {
        StaticSuper sup = new StaticSub();
        System.out.println(sup.staticGet());
        System.out.println(sup.dynamicGet());
    }
}
