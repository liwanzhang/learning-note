package zwl.learning.note.string;

import org.junit.Test;
import org.springframework.util.StringUtils;
import zwl.learning.note.util.Print;

/**
 * @Description: TODO
 * @Author zhangwanli
 * @Date 2020/6/11 11:36
 * @Version V1.0
 **/
public class StringTest {

    @Test
    public void hexTest2() {
        Print.printFullBinaryStringInt(1185355952);
        int i = 0x40000000;
        Print.printFullBinaryStringInt(i);
        i = i << 31;
        Print.printFullBinaryStringInt(i);

        Print.printFullBinaryStringInt(197973617);
    }


    @Test
    public void hexTest() {
        byte b = 0x00;
        byte b2 = 0x70;
        Print.printFullBinaryStringByte(b);
        Print.printFullBinaryStringInt(b);
        Print.printFullBinaryStringByte(b2);
        Print.printFullBinaryStringInt(b2);

        byte dcs = 0x00;
        dcs |= 0x08;
        Print.printFullBinaryStringByte(dcs);
        Print.printFullBinaryStringInt(dcs);

    }

    @Test
    public void stringTest() {
        String sms = "【费用提醒】尊敬的客户，70字长短信测试70字长短信测试70字长短信测试70字长短信测试70字长短信测试70字长短信测试70字长短信测试70字长短信测试70字长短信测试70字长短信测试70字长短信测试70字长短信测试70字长短信测试";
        String sms2 = "a【费用提醒】尊敬的客户，70字长短信测试70字长短信测试70字长短信测试70字长短信测试70字长短信测试70字长短信测试70字长短信测试70字长短信测试70字长短信测试70字长短信测试70字长短信测试70字长短信测试70字长短信测试";
        boolean r = haswidthChar(sms);
        Print.println(r);
        boolean r2 = haswidthChar(sms2);
        Print.println(r2);
    }

    private static boolean haswidthChar(String content) {

        byte[] bytes = content.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            // 判断最高位是否为1
//            Print.printFullBinaryString(bytes[i]);
            Print.printFullBinaryStringByte(bytes[i]);
            Print.printFullBinaryStringInt(bytes[i]);
            Print.printFullBinaryStringByte((byte) 0x80);
            Print.printFullBinaryStringInt((byte) 0x80);
            Print.printFullBinaryStringInt(bytes[i] & (byte) 0x80);
            if ((bytes[i] & (byte) 0x80) == (byte) 0x80) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void rpTest() {
        String messageId = "8946165564515529";
        Print.println(messageId);
        messageId = messageId.replace(messageId.charAt(messageId.length() - 1) + "", "0");
        Print.println(messageId);


        String str = "8946165564515529";
        String newChar = "0";
        Print.println(str);
        StringBuilder sb = new StringBuilder(str);
        sb.replace(str.length() - 1, str.length(), newChar);
        str = sb.toString();
        Print.println(str);

    }

}
