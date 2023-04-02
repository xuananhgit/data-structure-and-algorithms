package graph;

public class _200_Number_of_Islands {

    boolean[][] daDuyet = new boolean[300][300];
    int soHang;
    int soCot;

    public boolean isValid(int i, int j) {
        return i >= 0 && j >= 0 && i < soHang && j < soCot;
    }

    public void DFS(char[][] a, int i, int j) {
        if (!isValid(i, j) || a[i][j] == '0' || daDuyet[i][j]) {
            return;
        }
        daDuyet[i][j] = true;

        DFS(a, i, j + 1);
        DFS(a, i, j - 1);
        DFS(a, i - 1, j);
        DFS(a, i + 1, j);
    }

    public int numIslands(char[][] grid) {
        var count = 0;
        soHang = grid.length;
        soCot = grid[0].length;
        for (int i = 0; i < soHang; i++) {
            for (int j = 0; j < soCot; j++) {
                if (grid[i][j] == '1' && !daDuyet[i][j]) {
                    DFS(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }
}
