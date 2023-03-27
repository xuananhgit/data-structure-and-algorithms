package mergesort;

import java.util.Arrays;

public class MyMergeSort {

    public static int[] mergeSort(int[] a, int l, int r) {

        if (l > r) {
            return new int[0];
        }
        if (l == r) {
            System.out.println("return: " + "["+a[l]+"]");
            return new int[]{a[l]};
        }

//        System.out.println("Chia: " + l + " - " + r);
        var k = (l + r) / 2;
        System.out.println("left = " + l + " - right = " + k);
        var a1 = mergeSort(a, l, k);
        System.out.println("left = " + (k + 1) + " - right = " + r);
        var a2 = mergeSort(a, k + 1, r);

        int[] result = merge(a1, a2);
        System.out.println("Ket qua merge: " + Arrays.toString(result));
        return result;
    }

    private static int[] merge(int[] a1, int[] a2) {
        var n = a1.length + a2.length;

        var result = new int[n];

        int i = 0, i1 = 0, i2 = 0;

        while (i < n) {
            if (i1 < a1.length && i2 < a2.length) { //a1 va a2 khac rong
                if (a1[i1] < a2[i2]) {
                    result[i] = a1[i1];
                    i++; i1++;
                } else {
                    result[i] = a2[i2];
                    i++; i2++;
                }
            } else {
                if (i1 < a1.length) {
                    result[i] = a1[i1];
                    i++; i1++;
                } else {
                    result[i] = a2[i2];
                    i++; i2++;
                }
            }
        }
        return result;
    }

    public static int[] sortArray(int[] array) {
        return mergeSort(array, 0, array.length - 1);
    }

    public static void main(String[] args) {
        int[] a1 = {1, 3, 5, 7, 9};
        int[] a2 = {2, 4, 6, 8, 10};

        int[] c = {1, 5, 3, 2, 8, 7, 6, 4};

        System.out.println(Arrays.toString(sortArray(c)));
     }
}
