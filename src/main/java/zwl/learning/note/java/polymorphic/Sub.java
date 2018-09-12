package zwl.learning.note.java.polymorphic;

/**
 * @author zhangwanli
 * @description
 * @date 2018-08-14 下午3:40
 */
public class Sub extends Super {
    public int field = 1;

    public int getField() {
        return field;
    }

    public int getSuperField() {
        return super.field;
    }
}