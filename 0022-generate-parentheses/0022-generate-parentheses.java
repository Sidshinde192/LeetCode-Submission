class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        if(n == 0){
            return ans;
        }

        dfs("",0,0,n, ans);

        return ans;
    }

    public void dfs(String curr, int open, int close, int n, List<String> ans){
        if(curr.length() == 2 * n){
            ans.add(curr);
            return;
        }

        if(open < n){
            dfs(curr + "(", open + 1, close, n, ans);
        }

        if(close < open){
            dfs(curr + ")", open, close + 1, n, ans);
        }
    }
}