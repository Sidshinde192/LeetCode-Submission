class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        int start =s.length() -1;

        while(start >= 0){
            while(start >=0 && s.charAt(start) == ' '){
                start--;
            }

            if(start < 0){
                break;
            }

            int end = start;

            while(start >= 0 && s.charAt(start) != ' '){
                start--;
            }

            if(ans.length() == 0){
                ans.append(s.substring(start+1, end+1));
            }
            else{
                ans.append(" ");
                ans.append(s.substring(start+1, end+1));
            }
        }

        return ans.toString();
    }
}