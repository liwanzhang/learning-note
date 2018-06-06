package zwl.learning.note.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangwanli
 * @description
 * @date 2018-04-03 下午5:23
 */
public class ListDiff {

    static final int N = 50000;

    static long timeList(List list) {
        long start = System.currentTimeMillis();
        Object o = new Object();
        for (int i = 0; i < N; i++) {
            list.add(0, o);
        }
        return System.currentTimeMillis() - start;
    }

    static long timeList2(List list) {
        long start = System.currentTimeMillis();
        Object o = new Object();
        for (int i = 0; i < N; i++) {
            list.add(o);
        }
        return System.currentTimeMillis() - start;
    }

    static long readList(List list) {
        long start = System.currentTimeMillis();
        for (int i = 0, j = list.size(); i < j; i++) {

        }
        return System.currentTimeMillis() - start;
    }

    static List addList(List list) {
        Object o = new Object();
        for (int i = 0; i < N; i++) {
            list.add(0, o);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println("ArrayList添加" + N + "条耗时：" + timeList(new ArrayList()));
        System.out.println("LinkedList添加" + N + "条耗时：" + timeList(new LinkedList()));

        System.out.println("ArrayList添加" + N + "条耗时：" + timeList2(new ArrayList()));
        System.out.println("LinkedList添加" + N + "条耗时：" + timeList2(new LinkedList()));

        List list1 = addList(new ArrayList<>());
        List list2 = addList(new LinkedList<>());
        System.out.println("ArrayList查找" + N + "条耗时：" + readList(list1));
        System.out.println("LinkedList查找" + N + "条耗时：" + timeList(list2));
    }
}
