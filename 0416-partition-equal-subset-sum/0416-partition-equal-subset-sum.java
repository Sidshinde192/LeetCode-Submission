class Solution {

    public boolean solve(int i, int target, int [] nums, int [][] dp){
        if(target == 0){
            return true;
        }

        if(i ==0){
            return nums[0] == target;
        }

        if(dp[i][target] != -1){
            return dp[i][target] == 1;
        }

        boolean noTake = solve(i-1, target, nums, dp);

        boolean take = false;

        if(nums[i] <= target){
            take = solve(i-1, target - nums[i], nums, dp);
        }
        dp[i][target] = (take || noTake) ? 1 : 0;

        return take || noTake;
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int totalSum =0;
        for(int num : nums){
            totalSum += num;
        }

        if(totalSum % 2 != 0){
            return false;
        }

        int target = totalSum /2;

        boolean [][] dp = new boolean[n+1][target+1];

        for(int i =0; i< n;i++){
            dp[i][0] = true;
        }

        if(nums[0] <= target){
            dp[0][nums[0]] = true;
        }

        for(int i =1; i<n;i++){
            for(int t =1; t<= target;t++){
                boolean noTake = dp[i-1][t];
                boolean take = false;
                if(nums[i] <= t){
                    take = dp[i-1][t-nums[i]];
                }
                dp[i][t] = noTake || take;
            }
        }

        return dp[n-1][target];


    }
}