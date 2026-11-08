class Solution {
    public int countServers(int[][] grid) {
         int rows = grid.length;
      int cols = rows ==0?0:grid[0].length;

      int servers =0;
       int RowCount[] = new int[rows];
       int ColCount [] = new int [cols];

       for(int row =0; row< rows; row++)
       {
        for(int col = 0; col< cols; col++)
        {
            if(grid[row][col] == 1)
            {
                RowCount[row]++;
                ColCount[col]++;

            }
        }
       }
       for(int row =0; row<rows;row++)
       {
         for(int col =0; col <cols;col++)
         {
            if(grid[row][col] ==1 && (RowCount[row] > 1 || ColCount[col] >1))
            {
                servers++;
            }
         }
       }
       return servers;
    }
}