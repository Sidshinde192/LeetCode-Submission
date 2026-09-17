class Solution {
    public void dfs(int row, int col, int [][] visited, char[][] board, int [] dr, int [] dc, int n, int m){
        visited[row][col] = 1;

        for(int i =0; i< 4;i++){
            int nrow = dr[i] + row;
            int ncol = dc[i] + col;

            if(nrow >=0 && nrow < n && ncol >=0 && ncol <m && visited[nrow][ncol] == 0 && board[nrow][ncol] == 'O'){
                dfs(nrow, ncol, visited, board, dr, dc, n, m);
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int [][] visited = new int[n][m];
        int [] dr = {-1, 0,1,0};
        int [] dc = {0,1,0,-1};

        for(int i =0; i< n;i++){
            if(visited[i][0] == 0 && board[i][0] == 'O'){
               dfs(i, 0, visited, board, dr, dc, n, m);
            }

            if(visited[i][m-1] == 0 && board[i][m-1] == 'O'){
                dfs(i, m-1, visited, board, dr, dc, n, m);
            }
        }

        for(int j =0; j<m;j++){
            if(visited[0][j] == 0 && board[0][j] == 'O'){
                dfs(0, j, visited, board, dr, dc, n, m);
            }

            if(visited[n-1][j] == 0 && board[n-1][j] == 'O'){
                dfs(n-1, j, visited, board, dr, dc, n, m);
            }
        }

        for(int i =0; i< n;i++){
            for(int j =0; j< m;j++){
                if(board[i][j] == 'O' &&visited[i][j] == 0){
                    board[i][j] = 'X';
                }
            }
        }
    }
}