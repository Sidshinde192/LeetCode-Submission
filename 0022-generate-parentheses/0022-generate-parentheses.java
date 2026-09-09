class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        if(n == 0){
            return ans;
        }

        solve("", 0, 0, ans, n);

        return ans;
    }

    public void solve(String curr, int open, int close, List<String> ans, int total){
        if(curr.length() == 2 * total){
            ans.add(curr);
            return;
        }

        if(open < total){
            solve(curr + "(", open + 1, close, ans, total);
        }

        if(close < open){
            solve(curr + ")", open , close + 1, ans, total);
        }
    }
}