package classtasks.arrays;

import java.util.Arrays;

public class ArraySort {

    public static void main(String[] args) {
        int[] a = {20, 6, 136913, 51395, 1357};
        int[] res = new int[a.length];
        Arrays.sort(a);

        boolean flag = true;
        int leftIndex = 0, rightIndex = res.length - 1;
        for (int i = a.length - 1; i > 0; i--) {

            if (flag) {
                res[leftIndex++] = a[i];
                flag = false;
            } else {
                res[rightIndex--] = a[i];
                flag = true;
            }
        }
        System.out.println(Arrays.toString(res));

    }
}
