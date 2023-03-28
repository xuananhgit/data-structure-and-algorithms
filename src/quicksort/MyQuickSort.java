package quicksort;

import java.util.Arrays;

public class MyQuickSort {

    public static void quickSort(int[] a, int l, int r) {
        System.out.println(Arrays.toString(Arrays.copyOfRange(a, l, r + 1)));
        if (l >= r) {
            return;
        }
        var key = a[(l + r) / 2];
        int k = partition(a, l, r, key);
        quickSort(a, l, k - 1);
        quickSort(a, k, r);
    }

    private static int partition(int[] a, int l, int r, int key) {
        while (l <= r) {
            while (a[l] < key) l++;
            while (a[r] > key) r--;
            if (l <= r) {
                var temp = a[l];
                a[l] = a[r];
                a[r] = temp;
                l++; r--;
            }
        }

          return l;
    }


    public static void main(String[] args) {
        int[] array = {-1,2,-8,-10};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
