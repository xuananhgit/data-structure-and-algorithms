package binarysearch;

public class BinarySearch {


    public static int binarySearch(int[] array, int key) {
        var n = array.length;
        var iLeft = 0;
        var iRight = n - 1;

        while (iLeft <= iRight) {
            var iMid = (iLeft + iRight) / 2;

            System.out.println("["+iLeft+","+iRight+"] xet " + + iMid);
            if (key == array[iMid]) {
                return iMid;
            }

            if (key > array[iMid]) {
                iLeft = iMid + 1;
            }

            if (key < array[iMid]) {
                iRight = iMid - 1;
            }
        }


        return -1;
    }

    public static int bSearch(int[] array, int key, int iLeft, int iRight) {
        if (iLeft > iRight) {
            return -1;
        }
        var iMid = (iLeft + iRight) / 2;

        if (key == array[iMid]) {
            return iMid;
        } else if (key > array[iMid]) {
            return bSearch(array, key, iMid + 1, iRight);
        } else  {
            return bSearch(array, key, iLeft, iMid - 1);
        }
    }

    public static int bSearch(int[] array, int key) {
        var n = array.length;
        return bSearch(array, key, 0, n - 1);
    }


    public static void main(String[] args) {
        int[] array = {1, 4, 9, 12, 19, 25, 31, 46, 50, 57, 72};
        System.out.println(bSearch(array, 31));
    }
}