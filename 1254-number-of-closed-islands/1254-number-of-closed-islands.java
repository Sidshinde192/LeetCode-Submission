class Solution {
    int n;
    int m;
    public boolean dfs(int [][] grid, int r, int c){
        if(r >= n || r < 0 || c >= m || c < 0){
            return false;
        }

        if(grid[r][c] == 1){
            return true;

        }

        grid[r][c] = 1;

        boolean left = dfs(grid, r, c-1);
        boolean right = dfs(grid, r, c+1);
        boolean down = dfs(grid, r+1, c);
        boolean up = dfs(grid, r-1, c);

        return left && right && down && up;


    }
    public int closedIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int count =0;

        for(int i =0; i< n;i++){
            for(int j =0; j< m;j++){
                if(grid[i][j] == 0){
                    if(dfs(grid, i, j)){
                        count++;
                    }
                }
            }
        }

        return count;
        
    }
}