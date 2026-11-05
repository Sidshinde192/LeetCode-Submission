class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if(n > m){
            return false;
        }

        int [] freq = new int[26];

        for(char ch : s1.toCharArray()){
            freq[ch - 'a']++;
        }

        int[] freq2 = new int[26];
        int left =0;
        int right =0;
        

        while(right < m){
           
            freq2[s2.charAt(right) - 'a']++;

            if(right - left + 1 > n){
                freq2[s2.charAt(left) - 'a']--;
                left++;
            }

             if (right - left + 1 == n) {
                int count = 0;

                for (int i = 0; i < 26; i++) {
                    if (freq[i] == freq2[i]) {
                        count++;
                    }
                }

                if (count == 26) {
                    return true;
                }
            }

            right++;
        }

        return false;
    }
}