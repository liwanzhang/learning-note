package zwl.learning.note;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: TODO
 * @Author zhangwanli
 * @Date 2020/9/15 15:12
 * @Version V1.0
 **/
public class GenericTest {

    @Test
    public void test() {

        int[] num = {27685, 11570, 5492, 42042, 41938, 19100, 10741, 18415};
        List<Integer> numL = Arrays.asList(27685, 11570, 5492, 42042, 41938, 19100, 10741, 18415);
        List<Double> numK = new ArrayList<>();
        List<Double> numM = new ArrayList<>();
        int lc = 0;
        for (int n : num) {
            lc += n;
        }
        System.out.println("7日平均：" + lc/7);
        System.out.println("7日平均：" + (lc/7) * 5);
        System.out.println("7日最大：" + 42042 * 5);
        double d = ((lc/7) * 80 ) / 1024;
        System.out.println("7日平均：" + String.format("%.2f", d));
        d = ((126415) * 80 ) / 1024;
        System.out.println("7日平均：" + String.format("%.2f", d));
        d = ((210210) * 80 ) / 1024;
        System.out.println("7日最大：" + String.format("%.2f", d));

        numK.forEach(i -> System.out.println(i));
        numM.forEach(f -> System.out.println(String.format("%.2f", f)));
        numM.forEach(f -> System.out.println(String.format("%.2f", f)));



    }
}
