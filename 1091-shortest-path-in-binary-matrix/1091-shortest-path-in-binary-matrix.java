class Solution {
    class Pair{
        int r;
        int c;
        int d;

        Pair(int r, int c, int d){
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] == 1 || grid[n-1][n-1] == 1){
            return -1;
        }

        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        q.add(new Pair(0,0,1));
        visited[0][0] = true;

        int [][] dir = {
            {-1,-1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
        };

        while(!q.isEmpty()){
            Pair curr = q.poll();
            int row = curr.r;
            int col = curr.c;
            int dis = curr.d;

            if(row == n-1 && col == n-1){
                return dis;
            }

            for(int [] dirs : dir){
                int nr = row + dirs[0];
                int nc = col + dirs[1];

                if(nr >=0 && nr < n && nc >=0 && nc < n && !visited[nr][nc] && grid[nr][nc] == 0){
                  visited[nr][nc] = true;
                  q.offer(new Pair(nr, nc, dis + 1));
                }
            }
        }

        return -1;


    }
}