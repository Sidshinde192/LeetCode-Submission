class Solution {
    public List<List<String>> solveNQueens(int n) {
        char [][] board = new char[n][n];

        for(int i =0; i< n;i++){
            for(int j =0; j< n;j++){
                board[i][j] = '.';
            }
        }

        int [] leftrow = new int[n];
        int [] leftDigonal = new int[2 * n -1];
        int [] rightDigonal = new int[2 * n -1];

        List<List<String>> ans = new ArrayList<>();

        solve(0, ans, board, leftrow, leftDigonal, rightDigonal);
        return ans;
    }

    public void solve(int col, List<List<String>> ans, char[][] board, int [] leftrow, int [] leftDigonal, int [] rightDigonal){
        if(col == board.length){
            List<String> temp = new ArrayList<>();

            for(int i =0; i< board.length;i++){
                temp.add(new String(board[i]));
            }

            ans.add(temp);
            return;
        }

        for(int row =0; row < board.length;row++){
            if(leftrow[row] == 0 && leftDigonal[row + col] == 0 && rightDigonal[board.length- 1 + col - row] == 0){
                board[row][col]= 'Q';
                leftrow[row] = 1;
                leftDigonal[row + col] = 1;
                rightDigonal[board.length -1 + col - row] = 1;
                solve(col + 1, ans, board, leftrow, leftDigonal, rightDigonal);
                board[row][col] = '.';
                leftrow[row] = 0;
                leftDigonal[row+col] = 0;
                rightDigonal[board.length-1+col - row] = 0;
            }
        }
    }
}