package zwl.learning.note.java.instance;

/**
 * @author zhangwanli
 * @description
 * @date 2018-07-17 下午4:06
 */
public class Glyph {

    public int i = 3;

    public Glyph() {
        System.out.println("Glyph() before draw()");
        System.out.println("Glyph() before draw() = " + i);
        draw();
        System.out.println("Glyph() after draw()");
    }

    void draw() {
        System.out.println("Glyph.draw()");
    }
}
