package graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class SampleDFSWithStack {

    public static void main(String[] args) {
        int[][] graph = {
                {0,1,0,0,0,0,0},
                {1,0,1,1,1,0,0},
                {0,1,0,0,0,1,0},
                {0,1,0,0,0,1,1},
                {0,1,0,0,0,0,1},
                {0,0,1,1,0,0,0},
                {0,0,0,1,1,0,0}

//                {0,1,0,0,0,0,0},
//                {0,0,1,1,1,0,0},
//                {0,0,0,0,0,1,0},
//                {0,0,0,0,0,1,1},
//                {0,0,0,0,0,0,1},
//                {0,0,0,0,0,0,0},
//                {0,0,0,0,0,0,0}
        };

        // Khai bao
        Stack<Integer> stack = new Stack<>();
        Set<Integer> daDuyet = new HashSet<>();

        // Khoi tao
        stack.add(0);
        daDuyet.add(0);

        // Duyet theo stack
        while (!stack.isEmpty()) {
            var u = stack.pop();
            // process u
            System.out.println(u + " ");
            // Add tat ca cac dinh ke v voi u ma chua duoc duyet vao stack

            for (int v = 0; v < graph.length; v++) {
                if (graph[u][v] == 1 && !daDuyet.contains(v)) {
                    stack.add(v);
                    daDuyet.add(v);
                }
            }
        }
    }
}
