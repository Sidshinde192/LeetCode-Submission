class Solution {
    Set<String> set = new HashSet<>();
    Boolean[] dp = new Boolean[301];
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        for(String word : wordDict){
            set.add(word);
        }

        return solve(0, n, s);
    }

    public boolean solve(int idx, int n, String s){
        if(idx == n){
            return true;
        }

        if(set.contains(s.substring(idx))){
    return true;
}

        if(dp[idx] != null){
            return dp[idx];
        }

        for(int l = idx; l < n;l++){
            String temp = s.substring(idx, l);

            if(set.contains(temp) && solve(l, n, s)){
                return dp[idx] = true;
            }
        }

        return dp[idx] = false;
    }
}