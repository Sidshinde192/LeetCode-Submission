class Solution {
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        int [] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    // public int f(int i, int n, int [] dp){
    //     if(i > n){
    //         return 0;
    //     }
    //     if(i == n){
    //         return 1;
    //     }
    //     if(dp[i] > 0){
    //         return dp[i];
    //     }

    //     return dp[i] = f(i+1, n, dp) + f(i+2, n, dp);
    // }
}