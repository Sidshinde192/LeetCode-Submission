class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();

        int [] last = new int[26];

        for(int i =0; i< s.length();i++){
            last[s.charAt(i) - 'a'] = i;
        }

        Stack<Integer> st = new Stack<>();
        boolean [] visited = new boolean[26];

        for(int i =0; i< n;i++){
            int ch = s.charAt(i) - 'a';

            if(visited[ch]){
                continue;
            }

            visited[ch] = true;

            while(!st.isEmpty() && st.peek() > ch && last[st.peek()] > i){
                visited[st.pop()] = false;
            }

            st.push(ch);
        }

        StringBuilder ans = new StringBuilder();

        for(int l : st){
            ans.append((char) (l + 'a'));
        }

        return ans.toString();



        
    }
}