class Solution {
    public int maximumWealth(int[][] accounts) {
        int n = accounts.length;
        int m = accounts[0].length;
        int maxWealth =0;

        for(int i =0; i<n;i++){
            int sum =0;
            for(int j =0;j<m;j++){
                sum += accounts[i][j];
            }
            maxWealth = Math.max(maxWealth, sum);
        }

        return maxWealth;
    }
}