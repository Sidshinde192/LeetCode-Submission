class Solution {
    class Pair{
        int r;
        int c;

        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int [][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<>();

        for(int i =0; i< n;i++){
            for(int j =0;j<m;j++){
                if(i == 0 || i == n-1 || j ==0 || j == m-1){
                    if(vis[i][j] == 0 && grid[i][j] == 1){
                        q.add(new Pair(i, j));
                        vis[i][j] = 1;
                    }
                }
            }
        }

        int [] dr = {-1, 0, 1, 0};
        int [] dc = {0,1,0,-1};

        while(!q.isEmpty()){
            Pair curr = q.poll();
            int row = curr.r;
            int col = curr.c;

            for(int i =0; i< 4;i++){
                int nrow = dr[i] + row;
                int ncol = dc[i] + col;

                if(nrow < n && nrow >=0 && ncol >=0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }

        int count =0;

        for(int i =0; i< n;i++){
            for(int j =0;j< m;j++){
                if(grid[i][j] == 1 && vis[i][j] == 0){
                    count++;
                }
            }
        }

        return count;
    }
}