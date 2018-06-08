package zwl.learning.note.sort;

/**
 * @author zhangwanli
 * @description
 * @date 2018-06-06 上午11:37
 */
public class BinarySearch {

    public static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] l = {0, 49, 38, 65, 97, 76, 13, 27, 49};

        int i = indexOf(l, 13);

        System.out.println(i);
    }
}
