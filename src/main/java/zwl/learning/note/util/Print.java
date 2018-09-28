package zwl.learning.note.util;

import java.text.DecimalFormat;

/**
 * @author zhangwanli
 * @description
 * @date 2018-09-12 下午5:48
 */
public class Print {

    /**
     * 完整显示整型数据的二进制格式
     */
    public static void printFullBinaryString(int x) {
        int[] buffer = new int[Integer.SIZE];
        for (int i = (Integer.SIZE - 1); i >= 0; i--) {
            buffer[i] = x >> i & 1;
        }
        String s = "";
        for (int j = (Integer.SIZE - 1); j >= 0; j--) {
            s = s + buffer[j];
        }
        System.out.println(s);
    }

    public static void printBinaryString(int i) {
        String format = Integer.toBinaryString(i);
        System.out.println(format);
    }

    /**
     *
     */
    public static void println(Object o) {
        System.out.println(o);
    }

    /**
     *
     */
    public static void printHorizontalLine() {
        println("--------------------------------");
    }

    /**
     *
     */
    public static String print4(int x) {
        DecimalFormat df = new DecimalFormat("0000");
        String s = df.format(x);
        return s;
    }

}
