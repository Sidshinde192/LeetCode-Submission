class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();

        int n = num.length();

        for(int i =0; i<n;i++){
            char ch = num.charAt(i);

            while(!st.isEmpty() && k > 0 && st.peek() > ch){
                st.pop();
                k--;
            }

            st.push(ch);
        }

        while(!st.isEmpty() && k > 0){
            st.pop();
            k--;
        }

        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        ans.reverse();

        while(ans.length() > 0 && ans.charAt(0) == '0'){
            ans.deleteCharAt(0);
        }

        return ans.length() > 0 ? ans.toString() : "0";
    }
}