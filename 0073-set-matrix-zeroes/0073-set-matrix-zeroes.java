import java.util.*;

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] visited = new boolean[m][n];
        boolean[][] zeroes = new boolean[m][n];

        for (boolean[] arr : visited) {
            Arrays.fill(arr, false);
        }

        // Original zeroes ko mark karna
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    zeroes[i][j] = true;
                }
            }
        }

        solve(m, n, matrix, visited, zeroes);
    }

    public void solve(int m, int n, int[][] grid,
                      boolean[][] visited, boolean[][] zeroes) {

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (zeroes[i][j] && !visited[i][j]) {
                    DFS(i, j, m, n, grid, visited, zeroes);
                }
            }
        }
    }

    public void DFS(int i, int j, int m, int n,
                    int[][] grid, boolean[][] visited,
                    boolean[][] zeroes) {

        if (i < 0 || j < 0 || i >= m || j >= n
                || visited[i][j]) {
            return;
        }

        visited[i][j] = true;

        if (zeroes[i][j]) {
            for (int col = 0; col < n; col++) {
                grid[i][col] = 0;
            }

            for (int row = 0; row < m; row++) {
                grid[row][j] = 0;
            }
        }

        DFS(i + 1, j, m, n, grid, visited, zeroes);
        DFS(i - 1, j, m, n, grid, visited, zeroes);
        DFS(i, j + 1, m, n, grid, visited, zeroes);
        DFS(i, j - 1, m, n, grid, visited, zeroes);
    }
}