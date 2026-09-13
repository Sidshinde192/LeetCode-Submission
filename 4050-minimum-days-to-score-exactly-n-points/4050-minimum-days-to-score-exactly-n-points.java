class Solution {
    public int solve(int total, int earn, int day, int [][] dp){
        if(earn == total){
            return 0;
        }

        if (earn > total) {
            return 1000000;
        }

        if(dp[earn][day] != -1){
            return dp[earn][day];
        }

        int pick = 1 + solve(total, earn + day + 1, day + 1, dp);
        int skip = 1000000;

        if(day > 0){
            skip = 1 + solve(total, earn, 0, dp);
        }

        return dp[earn][day] = Math.min(pick,skip);
    }
    public int minDays(int n) {
         int maxDay =
            (int) ((Math.sqrt(8.0 * n + 1) - 1) / 2);
        int [][] dp = new int[n+1][maxDay + 2];

        for(int [] row : dp){
            Arrays.fill(row, -1);
        }


        return solve(n, 0, 0, dp);
    }
}