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
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.d - b.d);

        int[][] dis = new int[n][m];

        for(int i =0; i< n;i++){
            for(int j =0; j< m;j++){
                dis[i][j] = (int) 1e9;
            }
        }

        pq.add(new Pair(0, 0, 0));
        dis[0][0] = 0;

        int [] dr ={-1,0,1,0};
        int [] dc = {0,1,0,-1};

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int row = curr.r;
            int col = curr.c;
            int diff = curr.d;

            if(row == n-1 && col == m-1){
                return diff;
            }

            for(int i =0; i< 4;i++){
                int nr = row + dr[i];
                int nc = col + dc[i];

                if(nr >=0 && nc >=0 && nr < n && nc < m){
                    int neweff =Math.max(diff, Math.abs(heights[row][col] - heights[nr][nc]));

                    if(neweff < dis[nr][nc]){
                        dis[nr][nc] = neweff;
                        pq.add(new Pair(nr, nc, neweff));
                    }
                }
            }
        }

        return 0;

    }
}