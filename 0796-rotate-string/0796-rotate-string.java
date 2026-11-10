class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        StringBuilder ans = new StringBuilder(s);

        while(true){
            if(ans.toString().equals(goal)){
                return true;
            }

            char ch = ans.charAt(0);
            ans.deleteCharAt(0);
            ans.append(ch);

            n--;

            if(n == 0 && !ans.toString().equals(goal)){
                break;
            }
        }

        return false;
    }
}