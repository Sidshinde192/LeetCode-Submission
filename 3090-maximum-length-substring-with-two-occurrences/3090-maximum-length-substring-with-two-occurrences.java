class Solution {
    public int maximumLengthSubstring(String s) {
        int [] count = new int[26];
        int left =0;
        int res =0;

        for(int right = 0; right < s.length();right++){
            char ch = s.charAt(right);
            count[ch - 'a']++;

            while(count[ch-'a'] > 2){
                char ch2 = s.charAt(left);
                count[ch2-'a']--;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}