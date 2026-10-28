import java.util.*;

class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int minXor = Integer.MAX_VALUE;

        int maxXor = 0;
        for (int[] row : grid) {
            for (int val : row) {
                maxXor |= val;
            }
        }

        int[][][] dp = new int[m][n][maxXor + 1];

        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }

        int xor = solve(0, 0, 0, grid, dp);

        minXor = Math.min(xor, minXor);

        return minXor;
    }

    public int solve(int x, int y, int xor, int[][] grid, int[][][] dp) {
        int m = grid.length;
        int n = grid[0].length;

        // Boundary Condition
        if (x >= m || y >= n) {
            return Integer.MAX_VALUE;
        }

        xor ^= grid[x][y];

        if (x == m - 1 && y == n - 1) {
            return xor;
        }

        if (dp[x][y][xor] != -1) {
            return dp[x][y][xor];
        }

        int right = solve(x, y + 1, xor, grid, dp);
        int down = solve(x + 1, y, xor, grid, dp);

        dp[x][y][xor] = Math.min(right, down);

        return dp[x][y][xor];
    }
}