package zwl.learning.note.java.instance.polymorphic;

/**
 * @author zhangwanli
 * @description
 * @date 2018-07-17 下午4:19
 */
public class StaticSub extends StaticSuper {

    public static String staticGet() {
        return "Derived staticGet()";
    }

    public String dynamicGet() {
        return "Derived dynamicGet()";
    }
}
