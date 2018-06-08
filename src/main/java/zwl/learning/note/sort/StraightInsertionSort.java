package zwl.learning.note.sort;

import com.alibaba.fastjson.JSON;

/**
 * @author zhangwanli
 * @description
 * @date 2018-06-05 下午10:23
 */
public class StraightInsertionSort {

    public static void insertSort(int[] l) {
        System.out.println(JSON.toJSONString(l));
        for (int i = 2; i < l.length; i++) {
            if (LT(l[i], l[i - 1])) {
                l[0] = l[i];
                l[i] = l[i - 1];
                int k = i-2;
                for (int j = i - 2; LT(l[0], l[j]); --j) {
                    l[j + 1] = l[j];
                    --k;
                }
                System.out.println(k);
                l[k+1] = l[0];
            }

            System.out.println("i=" + i + "  " + JSON.toJSONString(l));
        }
        System.out.println(JSON.toJSONString(l));
    }

    public static boolean LT(int i, int j) {
        if (i < j) return true;
        return false;
    }

    public static void insertionSort(int[] a) {
        System.out.println(JSON.toJSONString(a));
        int tmp;
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    tmp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = tmp;
                }
            }
        }
        System.out.println(JSON.toJSONString(a));
    }

    public static void main(String[] args) {
        int[] l = {0, 49, 38, 65, 97, 76, 13, 27, 49};

//        insertSort(l);
        insertionSort(l);
    }
}
