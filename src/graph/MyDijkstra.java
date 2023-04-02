package graph;

import java.util.HashSet;
import java.util.Set;

public class MyDijkstra {
    public static void main(String[] args) {
        var n = 5;
        int[][] a = {
                {0,6,0,1,0},
                {6,0,5,2,2},
                {0,5,0,0,5},
                {1,2,0,0,1},
                {0,2,5,1,0}};
        Set<Integer> visited = new HashSet<>();
        int[] distance = new int[n]; // distance[i] = khoang cach tu dau cho den i
        int[] previous = new int[n]; // previous[i] la dinh ngay phia truoc cua i

        var start = 0;
        var finish = 2;
        var oo = Integer.MAX_VALUE;
        //Buoc 1: khoi tao khoang cach
        for (int i = 0; i < n; i++) {
            distance[i] = oo;
        }
        distance[start] = 0;

        while (visited.size() < n) {
            // Buoc 2: chon dinh chua duyet
            // va dang co khoang cach nho nhat (tu dinh xuat phat) lam dinh dang xet
            var dangXet = 0;
            var minDis = oo;
            for (int i = 0; i < n; i++) {
                if (!visited.contains(i) && distance[i] < minDis) {
                    minDis = distance[i];
                    dangXet = i;
                }
            }

            // Buoc 3: Tu dinh dang xet, duyet cac dinh ke chua duyet
            // update khoang cach va dinh truoc cua cac dinh do
            for (int i = 0; i < n; i++) {
                if (!visited.contains(i) && a[dangXet][i] != 0) {
                    var newDistance = distance[dangXet] + a[dangXet][i];
                    if (newDistance < distance[i]) {
                        distance[i] = newDistance;
                        previous[i] = dangXet;
                    }
                }
            }
            // Buoc 4: Danh dau dinh dang xet thanh dinh da duyet
            visited.add(dangXet);
        }
        System.out.println("Khoang cach nho nhat tu " + start + " den " + finish + ": " + distance[finish]);

        System.out.println("Duong di la:");

        var chay = finish;
        while (chay != start) {
            System.out.print(chay + "<-");
            chay = previous[chay];
        }
        System.out.print(chay);
    }
}
