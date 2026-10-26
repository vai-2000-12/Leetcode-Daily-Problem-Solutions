import java.util.*;

class Solution {

    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] > 0 && !visited[i][j]) {

                   long sum = dfs(i, j, m, n, grid, visited);

                    if (sum % k == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public long dfs(int i, int j, int m, int n,
            int[][] grid, boolean[][] visited) {

        if (i < 0 || j < 0 || i >= m || j >= n ||
                grid[i][j] == 0 || visited[i][j]) {
            return 0L;
        }

        visited[i][j] = true;

        long sum = grid[i][j];

        sum += dfs(i + 1, j, m, n, grid, visited);
        sum += dfs(i - 1, j, m, n, grid, visited);
        sum += dfs(i, j + 1, m, n, grid, visited);
        sum += dfs(i, j - 1, m, n, grid, visited);

        return sum;
    }
}