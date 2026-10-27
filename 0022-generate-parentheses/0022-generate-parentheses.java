class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        if(n == 0){
            return ans;
        }

        dfs("", 0 , 0, ans, n);

        return ans;
    }

    public void dfs(String curr, int open, int close, List<String> ans, int n){
        if(curr.length() == 2 * n){
            ans.add(curr);
            return;
        }

        if(open < n){
            dfs(curr + "(", open + 1, close, ans, n);
        }

        if(close < open){
            dfs(curr + ")", open, close+1, ans, n);
        }
    }
}