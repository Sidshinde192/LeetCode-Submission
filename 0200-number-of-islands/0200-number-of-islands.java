class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int [][] visited = new int[n][m];
        int [] dr = {-1,0,1,0};
        int [] dc = {0,1,0,-1};
        int count =0;


        for(int i =0; i< n;i++){
            for(int j =0; j< m;j++){
                if(grid[i][j] == '1' && visited[i][j] == 0){
                    count++;
                    dfs(i, j, grid, visited, dr, dc, n, m);
                }
            }
        }

        return count;
    }

    public void dfs(int row, int col, char[][] grid, int [][] visited, int [] dr, int [] dc, int n, int m){
        visited[row][col] = 1;

        for(int i =0; i< 4;i++){
            int nrow = dr[i] + row;
            int ncol = dc[i] + col;

            if(nrow >= 0 && ncol >=0 && nrow < n && ncol < m && grid[nrow][ncol] =='1' && visited[nrow][ncol] == 0){
                dfs(nrow, ncol, grid, visited, dr, dc, n, m);
            }
        }
    }
}