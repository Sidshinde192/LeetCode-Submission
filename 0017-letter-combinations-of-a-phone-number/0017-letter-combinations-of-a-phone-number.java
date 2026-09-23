class Solution {
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        List<String> ans = new ArrayList<>();

        if(n == 0){
            return ans;
        }

        Map<Character, String> map = new HashMap<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        solve(0, "", digits, ans, map);
        return ans;
    }

    public void solve(int idx, String curr, String digits, List<String> ans, Map<Character, String> map){
        if(idx == digits.length()){
            ans.add(curr);
            return;
        }

        char ch = digits.charAt(idx);
        String str = map.get(ch);

        for(int i =0; i< str.length();i++){
            solve(idx+1, curr + str.charAt(i), digits, ans,map);
        }
    }
}