package heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class HeapInJava {

    public static void main(String[] args) {
        Queue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap.add(10);
        minHeap.add(100);
        minHeap.add(20);
        minHeap.add(3);
        minHeap.add(2);

        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());
        }
    }
}
