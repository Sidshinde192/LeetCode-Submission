class Solution {
    int [] dp ;

     public int solve(int i, int n, int[] costs) {
        if (i == n) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int take1 = Integer.MAX_VALUE;
        int take2 = Integer.MAX_VALUE;
        int take3 = Integer.MAX_VALUE;

        if (i + 1 <= n) {
            take1 = costs[i] + 1
                    + solve(i + 1, n, costs);
        }

        if (i + 2 <= n) {
            take2 = costs[i + 1] + 4
                    + solve(i + 2, n, costs);
        }

        if (i + 3 <= n) {
            take3 = costs[i + 2] + 9
                    + solve(i + 3, n, costs);
        }

        return dp[i] = Math.min(take1,
                        Math.min(take2, take3));
    }
    public int climbStairs(int n, int[] costs) {
         dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(0, n, costs);
        
    }
}