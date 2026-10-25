class Solution {
    public int[] findPeakGrid(int[][] mat) {
       int n = mat.length;
        int m = mat[0].length;
        int low =0;
        int high = m-1;

        while(low<= high)
        {
            int mid = (low+high)/2;
            int maxindex = findmax( mat, mid);
            int left = mid-1 >= 0? mat[maxindex][mid-1] : -1;
            int right = mid+1 < m? mat[maxindex][mid+1]:-1;

            if(mat[maxindex][mid] > left && mat[maxindex][mid]>right){
                return new int[]{maxindex, mid};
            }
            else if(mat[maxindex][mid] < left){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return new int[]{-1,-1};
    }

    public int findmax(int[][] mat, int col){
        int n = mat.length;
        int m = mat[0].length;
        int max = -1;
        int index = -1;
        for(int i =0; i< n;i++)
        {
           if(mat[i][col] > max)
           {
            max = mat[i][col];
            index = i;
           }
        }
        return index;
    }
}