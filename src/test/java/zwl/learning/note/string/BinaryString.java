package zwl.learning.note.string;

import zwl.learning.note.util.Print;

/**
 * @author zhangwanli
 * @description
 * @date 2018-08-29 下午5:18
 */
public class BinaryString {

    public static void main(String[] args) {
        left();
        Print.printHorizontalLine();
        right();
        Print.printHorizontalLine();
        reverse();
    }

    /**
     * 左移
     * 二进制码整体左移，左边超出的部分舍弃，右边补零。
     */
    private static void left() {
        int i = 0x80000001;
        int r = i << 2;
        int a = i << 2;

        Print.printFullBinaryString(i);
        Print.printFullBinaryString(r);
        Print.printFullBinaryString(a);

        /*
        10000000000000000000000000000001
        00000000000000000000000000000100
        00000000000000000000000000000100
         */
    }

    /**
     * 右移
     * 二进制码整体右移，左边用原有符号位补充，右边超出部分舍弃。
     * 无符号右移
     * 二进制码整体右移，左边部分总是以0填充，右边超出部分舍弃。
     */
    private static void right() {
        int i = 0x80000001;
        int r = i >> 2;
        int a = i >>> 2;

        Print.printFullBinaryString(i);
        Print.printFullBinaryString(r);
        Print.printFullBinaryString(a);

        /*
        10000000000000000000000000000001
        11100000000000000000000000000000
        00100000000000000000000000000000
        */
    }

    /**
     * 取反~
     */
    private static void reverse() {
        int i = 1;
        int r = ~1;
        int a = 1 ^ 0;

        Print.printFullBinaryString(i);
        Print.printFullBinaryString(r);
        Print.printFullBinaryString(a);

        /*
        00000000000000000000000000000001
        11111111111111111111111111111110
        00000000000000000000000000000001
        */
    }
}
