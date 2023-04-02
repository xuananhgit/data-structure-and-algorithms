package heap;

import java.util.Scanner;

public class MyHeap {

    public static class MinHeap {
        private final int MAX_SIZE = 100;
        private final int[] arr = new int[MAX_SIZE + 1];
        private int size;

        public MinHeap() {
            size = 0;
        }

        public boolean isEmpty() {
            return size <= 0;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Error: Heap is empty!");
                return -1;
            }
            return arr[1];
        }

        private void swap(int i, int j) {
            var t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }

        public void add(int v) {
            size++;
            arr[size] = v;
            // heapify up
            var currentIndex = size;
            var parentIndex = currentIndex / 2;
            while (parentIndex != 0 && arr[parentIndex] > arr[currentIndex]) {
                swap(parentIndex, currentIndex);
                parentIndex = currentIndex/2;
            }
        }


        public int poll() {
            if (isEmpty()) {
                System.out.println("Error: Heap is empty!");
                return -1;
            }
            var minRoot = arr[1];
            // heapify down
            arr[1] = arr[size];
            size--;
            var currentIndex = 1;
            heapifyDown(currentIndex);
            return minRoot;
        }

        private void heapifyDown(int currentIndex) {
            while (2 * currentIndex <= size) {
                var leftChildIndex = 2 * currentIndex;
                var smallerChildIndex = leftChildIndex;
                var rightChildIndex = leftChildIndex + 1;
                if (rightChildIndex <= size && arr[rightChildIndex] < arr[leftChildIndex]) {
                    smallerChildIndex = rightChildIndex;
                }
                if (arr[currentIndex] > arr[smallerChildIndex]) {
                    swap(currentIndex, smallerChildIndex);
                    currentIndex = smallerChildIndex;
                } else {
                    break;
                }
            }
        }

        public void remove(int v) {
            var currentIndex = -1;
            for (int i = 0; i <= size; i++) {
                if (arr[i] == v) {
                    currentIndex = i;
                }
            }
            if (currentIndex == -1) {
                System.out.println("Error: Element is not exist!");
                return;
            }
            arr[currentIndex] = arr[size];
            size--;
            heapifyDown(currentIndex);
        }
    }

    public static void main(String[] args) {
        var myHeap = new MinHeap();
        var scanner = new Scanner(System.in);
        var q = scanner.nextInt();
        while (q > 0) {
            var t = scanner.nextInt();
            if (t == 1) {
                myHeap.add(scanner.nextInt());
            } else if (t == 2) {
                myHeap.remove(scanner.nextInt());
            } else {
                System.out.println(myHeap.peek());
            }
            q--;
        }
    }
}
