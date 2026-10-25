
class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && DFS(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean DFS(int[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;
        // Boundary Condition :
        if (r < 0 || c < 0 || r >= m || c >= n) {
            return false;
        }
         
         if(grid[r][c] ==1){ return true; } 
        
        // Mark as visited
        grid[r][c] = 1;
    
        boolean bottom = DFS(grid, r + 1, c);
        boolean top = DFS(grid, r - 1, c);
        boolean right = DFS(grid, r, c + 1);
        boolean left = DFS(grid, r, c - 1);

        return top && bottom && left && right;

    }
}