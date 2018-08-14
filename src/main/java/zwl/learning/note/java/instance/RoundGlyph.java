package zwl.learning.note.java.instance;

/**
 * @author zhangwanli
 * @description
 * @date 2018-07-17 下午4:07
 */
public class RoundGlyph extends Glyph {
    private int radius = 1;

    RoundGlyph(int r) {
        radius = r;
        System.out.println("RoundGlyph.RoundGlyph(). radius = " + radius);
    }

    public void draw() {
        System.out.println("RoundGlyph.draw(). radius = " + radius);
    }
}

