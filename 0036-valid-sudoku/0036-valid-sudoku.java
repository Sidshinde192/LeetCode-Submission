class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        int n = board.length;
        int m = board[0].length;

        for(int i =0; i< n;i++){
            for(int j =0; j< m;j++){
                if(board[i][j] == '.'){
                   continue;
                }

                char val = board[i][j];

                String row = val + "row_" + i;
                String col = val + "col_" + j;
                String box = val + "box_" + i/3 + "-" + j/3;

                if(set.contains(row) || set.contains(col) || set.contains(box)){
                    return false;
                }

                set.add(row);
                set.add(col);
                set.add(box);
            }
        }

        return true;
    }
}