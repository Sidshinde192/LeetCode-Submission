class Solution {
    class Pair{
        int r;
        int c;
        int t;

        Pair(int r, int c, int t){
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int countFresh =0;

        Queue<Pair> q = new LinkedList<>();
        int [][] visited = new int[n][m];

        for(int i =0; i< n;i++){
            for(int j =0; j< m;j++){
                if(grid[i][j] == 2){
                    visited[i][j] = 2;
                    q.add(new Pair(i, j, 0));
                }
                else if(grid[i][j] == 1){
                    countFresh++;
                }
            }
        }

        int count =0;
        int time =0;

        int [] dr = {-1, 0,1 ,0};
        int [] dc = {0, 1, 0, -1};

        while(!q.isEmpty()){
            Pair curr = q.poll();
            int row = curr.r;
            int col = curr.c;
            int tm = curr.t;

            time = Math.max(time, tm);

            for(int i =0; i < 4;i++){
                int nrow = dr[i] + row;
                int ncol = dc[i] + col;

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                    visited[nrow][ncol] = 2;
                    count++;
                    q.add(new Pair(nrow, ncol, tm + 1));
                }
            }
        }

        if(count != countFresh){
            return -1;
        }

        return time;
    }
}