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
        // int [] dp = new int[n];
        // Arrays.fill(dp, -1);

        // return solve(0,n-1,nums, dp);

        int prev2 =0;
        int prev = nums[0];

        for(int i =1; i<n;i++){
            int take = nums[i];

            if(i > 1){
                take += prev2;
            }

            int notTake = 0 + prev;

            int curr = Math.max(take, notTake);
            prev2 = prev;
            prev = curr;
        }

        return prev;


    }
}