class Solution {
    public int solve(int i, int n, int [] nums, int [] dp){
        if(i > n){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int take = nums[i] + solve(i+2, n, nums, dp);

        int notTake = 0 + solve(i+1, n, nums, dp);

        return dp[i] = Math.max(take, notTake);
        
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int [] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(0,n-1,nums, dp);
    }
}