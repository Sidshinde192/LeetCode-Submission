class Solution {
    public int characterReplacement(String s, int k) {
        int left =0;
        int right =0;
        int n = s.length();
        int maxf =0;
        int max =0;

        int [] freq = new int[26];

        while(right < n){

            char ch = s.charAt(right);

            freq[ch - 'A']++;

            maxf = Math.max(maxf, freq[ch - 'A']);

            if((right - left + 1) - maxf > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            if((right - left + 1) - maxf <= k){
                max = Math.max(max, right - left + 1);
                right++;
            }



        }

        return max;
    }
}