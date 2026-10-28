class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        int[] ans = new int[2];

        visited[0][0] = true;

        solve(0, 0, grid, visited, ans);

        return ans;
    }

    public void solve(int r, int c, char[][] grid,
                      boolean[][] visited, int[] ans) {

        ans[0] = r;
        ans[1] = c;

        int nr = r;
        int nc = c;

        char ch = grid[r][c];

        if (ch == 'L') {
            nc--;
        } else if (ch == 'R') {
            nc++;
        } else if (ch == 'U') {
            nr--;
        } else if (ch == 'D') {
            nr++;
        }

        int m = grid.length;
        int n = grid[0].length;

        if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
            return;
        }

        if (visited[nr][nc]) {
            return;
        }

        visited[nr][nc] = true;

        solve(nr, nc, grid, visited, ans);
    }
}