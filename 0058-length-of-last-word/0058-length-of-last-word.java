class Solution {
    public int lengthOfLastWord(String s) {
        int p = s.length();
        int length =0;

        while(p > 0){
            p--;

            if(s.charAt(p) != ' '){
                length++;
            }
            else{
                if(length > 0){
                    return length;
                }
            }
        }

        return length;
    }
}