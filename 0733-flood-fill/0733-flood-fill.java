class Solution {
    class Pair{
        int r;
        int c;

        public Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        int intialColor = image[sr][sc];

        if(intialColor == color){
            return image;
        }
        
        boolean[][] visited = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(sr, sc));
        visited[sr][sc] = true;
        image[sr][sc] = color;
        int [] dr = {-1,0,1,0};
        int [] dc = {0,1,0,-1};

        while(!q.isEmpty()){
            Pair curr = q.poll();
            int row = curr.r;
            int col = curr.c;

            for(int i =0; i < 4;i++){
                int nrow = dr[i] + row;
                int ncol = dc[i] + col;

                if(nrow >=0 && nrow < n && ncol >=0 && ncol < m && !visited[nrow][ncol] && image[nrow][ncol] == intialColor){
                    visited[nrow][ncol] = true;

                    image[nrow][ncol] = color;
                    q.offer(new Pair(nrow, ncol));
                }
            }
        }

        return image;
    }
}