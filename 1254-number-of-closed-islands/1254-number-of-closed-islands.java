class Solution {
    public int closedIsland(int[][] grid) {
         int n = grid.length;
        int m = grid[0].length;

        int count = 0;

        int[][] visited = new int[n][m];
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0 && visited[i][j] == 0) {
                    if (dfs(i, j, grid, visited, dr, dc)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public boolean dfs(int row, int col, int[][] grid,
                       int[][] visited, int[] dr, int[] dc) {

        visited[row][col] = 1;

        boolean closed = true;

        if (row == 0 || row == grid.length - 1 ||
            col == 0 || col == grid[0].length - 1) {
            closed = false;
        }

        for (int i = 0; i < 4; i++) {
            int nrow = row + dr[i];
            int ncol = col + dc[i];

            if (nrow >= 0 && nrow < grid.length &&
                ncol >= 0 && ncol < grid[0].length &&
                grid[nrow][ncol] == 0 &&
                visited[nrow][ncol] == 0) {

                if (!dfs(nrow, ncol, grid, visited, dr, dc)) {
                    closed = false;
                }
            }
        }

        return closed;
    }
}