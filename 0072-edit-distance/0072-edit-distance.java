class Solution {
    public int f(int i, int j, String s, String t, int [][] dp){
        if(i < 0){
            return j+1;
        }
        if(j < 0){
            return i+1;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = 0 + f(i-1, j-1, s, t, dp);
        }
        // i, j-1 insert
        //i-1, j delete
        //i-1, j-1 replace
        return dp[i][j] = Math.min(1 + f(i, j-1, s, t, dp), Math.min(1+f(i-1, j, s, t, dp), 1 + f(i-1, j-1, s,t, dp)));
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int [][] dp = new int[n+1][m+1];

        // for(int [] row : dp){
        //     Arrays.fill(row, -1);
        // }

        // return f(n-1, m-1, word1, word2, dp);

        for(int i =0; i<=n;i++){
            dp[i][0] = i;
        }

        for(int j =0; j<=m;j++){
            dp[0][j] = j;
        }

        for(int i =1; i<=n;i++){
            for(int j =1; j<=m;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.min(1+dp[i-1][j], Math.min(1 + dp[i-1][j-1],1 + dp[i][j-1]));
                }
            }
        }

        return dp[n][m];
    }
}