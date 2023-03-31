package stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCodeQueue933 {
    private Queue<Integer> myQueue = new LinkedList<>();
    public LeetCodeQueue933() {

    }

    public int ping(int t) {
        myQueue.add(t);

        while (myQueue.peek() < 3000 - t) {
            myQueue.remove();
        }

        return myQueue.size();
    }
}
