package hashtablesetandmap;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap706 {
    private final int SIZE = 1000;
    private final List<Data>[] myBuckets;

    private static class Data {
        private final int key;
        private int value;

        private Data(int key, int value) {
            this.key = key;
            this.value = value;
        }
        @Override
        public boolean equals(Object other) {
            if (other instanceof Data) {
                return this.key == ((Data) other).key;
            }
            return false;
        }
    }

    public MyHashMap706() {
        myBuckets = new List[SIZE];
        for (int i = 0; i < myBuckets.length; i++) {
            myBuckets[i] = new ArrayList<Data>();
        }
    }

    private int hashFunction(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int hashValueIndex = hashFunction(key);
        var bucket = myBuckets[hashValueIndex];
        var data = new Data(key, value);
        var keyIndex = bucket.indexOf(data);
        if (keyIndex < 0) {
            bucket.add(data);
        } else {
            bucket.get(keyIndex).value = value;
        }
    }

    public void remove(int key) {
        int hashValueIndex = hashFunction(key);
        var bucket = myBuckets[hashValueIndex];
        var data = new Data(key, 0);
        bucket.remove(data);
    }

    public int get(int key) {
        int hashValueIndex = hashFunction(key);
        var bucket = myBuckets[hashValueIndex];
        var data = new Data(key, 0);
        var keyIndex = bucket.indexOf(data);
        if (keyIndex >= 0) {
            return bucket.get(keyIndex).value;
        }
        return -1;
    }

    public static void main(String[] args) {
        MyHashMap706 map = new MyHashMap706();
        map.put(1, 1);
        map.put(1, 2);
        System.out.println(map.get(1));
    }
}
