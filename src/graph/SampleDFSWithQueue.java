package graph;

import java.util.*;

public class SampleDFSWithQueue {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 1, 0, 0},
                {0, 1, 0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 1},
                {0, 1, 0, 0, 0, 0, 1},
                {0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0}

//                {0,1,0,0,0,0,0},
//                {0,0,1,1,1,0,0},
//                {0,0,0,0,0,1,0},
//                {0,0,0,0,0,1,1},
//                {0,0,0,0,0,0,1},
//                {0,0,0,0,0,0,0},
//                {0,0,0,0,0,0,0}
        };

        // Khai bao
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> daDuyet = new HashSet<>();

        // Khoi tao
        queue.add(0);
        daDuyet.add(0);

        // Duyet theo stack
        while (!queue.isEmpty()) {
            var u = queue.poll();
            // process u
            System.out.println(u + " ");
            // Add tat ca cac dinh ke v voi u ma chua duoc duyet vao stack

            for (int v = 0; v < graph.length; v++) {
                if (graph[u][v] == 1 && !daDuyet.contains(v)) {
                    queue.add(v);
                    daDuyet.add(v);
                }
            }
        }
    }
}
