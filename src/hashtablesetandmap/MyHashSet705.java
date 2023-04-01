package hashtablesetandmap;

import java.util.ArrayList;
import java.util.List;

public class MyHashSet705 {
    private final int SIZE = 1000;
    private List[] myBuckets;

    public MyHashSet705() {
        myBuckets = new List[SIZE];
        for (int i = 0; i < myBuckets.length; i++) {
            myBuckets[i] = new ArrayList<Integer>();
        }
    }

    private int hashFunction(int key) {
        return key % SIZE;
    }

    public void add(int key) {
        int hashValueIndex = hashFunction(key);
        var bucket = myBuckets[hashValueIndex];
        int keyIndex = bucket.indexOf(key);

        if (keyIndex < 0) {
            bucket.add(key);
        }
    }

    public void remove(int key) {
        int hashValueIndex = hashFunction(key);
        var bucket = myBuckets[hashValueIndex];
        var keyIndex = bucket.indexOf(key);
        bucket.remove(keyIndex);
    }

    public boolean contains(int key) {
        int hashValueIndex = hashFunction(key);
        var bucket = myBuckets[hashValueIndex];
        var keyIndex = bucket.indexOf(key);
        return keyIndex >= 0;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println( s.lastIndexOf('e'));
    }
}
