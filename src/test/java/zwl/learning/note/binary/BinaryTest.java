package zwl.learning.note.binary;

import org.junit.Test;
import zwl.learning.note.util.Print;

/**
 * @author zhangwanli
 * @description
 * @date 2018-12-15 上午11:51
 */
public class BinaryTest {

    @Test
    public void bitCountTest() {
        int i = 0x7ffffff0;

        Print.printFullBinaryString(i);
        Print.println(i);
        Print.println(Integer.bitCount(i));
    }

    @Test
    public void isOdd() {
        int i = 0x7ffffff0;

        if (i % 2 == 0) {

        }


        if ((i & 1) == 1) {
        }
        Print.println((10 & 1) == 1);
    }


    @Test
    public void test() {

        Print.printFullBinaryString(1);
        Print.printFullBinaryString(1 << 16);
        Print.printFullBinaryString((1 << 16) - 1);
        Print.printFullBinaryString(~((1 << 16) - 1));
        Print.printFullBinaryString(0xffff0000);

        Print.printHorizontalLine();

        int a = 65837;
        Print.printFullBinaryString(a);
        Print.printFullBinaryString(a & 0xffff0000);
        Print.println(a & 0xffff0000);


    }


    @Test
    public void xor() {
        int a = 0x94218421, b = a >>> 16, c = a ^ b;
        Print.printFullBinaryString(a);
        Print.printFullBinaryString(b);
        Print.printFullBinaryString(c);


    }

    @Test
    public void bitCount() {
        int a = 0x8ff;

        Print.println(f5(a));
        Print.println(Integer.bitCount(a));

    }

    int f5(int x){
        x = (x & 0x55555555) + ((x & 0xaaaaaaaa) >> 1);
        x = (x & 0x33333333) + ((x & 0xcccccccc) >> 2);
        x = (x & 0x0f0f0f0f) + ((x & 0xf0f0f0f0) >> 4);
        x = (x & 0x00ff00ff) + ((x & 0xff00ff00) >> 8);
        x = (x & 0x0000ffff) + ((x & 0xffff0000) >> 16);
        return x;
    }

}
