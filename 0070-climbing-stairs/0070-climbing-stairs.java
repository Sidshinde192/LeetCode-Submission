class Solution {
    public int climbStairs(int n) {
        int [] dp = new int[n+1];
        return f(0, n, dp);
    }

    public int f(int i, int n, int [] dp){
        if(i > n){
            return 0;
        }
        if(i == n){
            return 1;
        }
        if(dp[i] > 0){
            return dp[i];
        }

        return dp[i] = f(i+1, n, dp) + f(i+2, n, dp);
    }
}