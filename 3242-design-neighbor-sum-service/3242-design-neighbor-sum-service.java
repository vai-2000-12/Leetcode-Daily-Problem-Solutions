class NeighborSum {
    int[][] grid;

    public NeighborSum(int[][] grid) {
        this.grid = grid;
    }

    public int adjacentSum(int value) {
        int n = grid.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == value) {
                    int sum = 0;

                    // Top
                    if (i - 1 >= 0)
                        sum += grid[i - 1][j];

                    // Bottom
                    if (i + 1 < n)
                        sum += grid[i + 1][j];

                    // Left
                    if (j - 1 >= 0)
                        sum += grid[i][j - 1];

                    // Right
                    if (j + 1 < n)
                        sum += grid[i][j + 1];

                    return sum;
                }
            }
        }

        return 0;
    }

    public int diagonalSum(int value) {
        int n = grid.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == value) {
                    int sum = 0;

                    // Top Left
                    if (i - 1 >= 0 && j - 1 >= 0)
                        sum += grid[i - 1][j - 1];

                    // Top Right
                    if (i - 1 >= 0 && j + 1 < n)
                        sum += grid[i - 1][j + 1];

                    // Bottom Left
                    if (i + 1 < n && j - 1 >= 0)
                        sum += grid[i + 1][j - 1];

                    // Bottom Right
                    if (i + 1 < n && j + 1 < n)
                        sum += grid[i + 1][j + 1];

                    return sum;
                }
            }
        }

        return 0;
    }
}