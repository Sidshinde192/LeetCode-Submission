class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 1){
            return s;
        }
        int n = s.length();

        String lps = "";

        for(int i = 1; i< n;i++){
            int low = i;
            int high = i;

            while(s.charAt(low) == s.charAt(high)){
                low--;
                high++;

                if(low == -1 || high == n){
                    break;
                }
            }

            String palindrome = s.substring(low+1, high);

            if(palindrome.length() > lps.length()){
                lps = palindrome;
            }

            low = i-1;
            high = i;

            while(s.charAt(low) == s.charAt(high)){
                low--;
                high++;
                if(low == -1 || high == n){
                    break;
                }
            }

            palindrome = s.substring(low+1, high);
            if(palindrome.length() > lps.length()){
                lps = palindrome;
            }



        }

        return lps;


    }
}