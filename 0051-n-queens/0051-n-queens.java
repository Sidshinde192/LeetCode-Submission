class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        char [][] board = new char[n][n];

        for(int i =0; i< n;i++){
            for(int j =0; j< n;j++){
                board[i][j] = '.';
            }
        }

        solve(0, ans, board);

        return ans;
    }

    public void solve(int col, List<List<String>> ans, char[][] board){
        if(col == board[0].length){
            List<String> temp = new ArrayList<>();

            for(int i =0; i< board.length;i++){
                temp.add(new String(board[i]));
            }

            ans.add(temp);
            return;
        }

        for(int row = 0; row < board.length;row++){
            if(canPlace(row, col, board)){
                board[row][col] = 'Q';
                solve(col + 1, ans, board);
                board[row][col] = '.';
            }
        }
    }

    public boolean canPlace(int row, int col, char[][] board){
        int dupRow = row;
        int dupCol = col;

        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q'){
                return false;
            }
            row--;
            col--;
        }

        row = dupRow;
        col = dupCol;

        while(col >= 0){
            if(board[row][col] == 'Q'){
                return false;
            }
            col--;
        }

        row = dupRow;
        col = dupCol;

        while(row < board.length && col >= 0){
            if(board[row][col] == 'Q'){
                return false;
            }

            row++;
            col--;
        }

        return true;
    }
}