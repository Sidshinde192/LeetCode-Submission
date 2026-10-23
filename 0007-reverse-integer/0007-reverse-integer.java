class Solution {
    public int reverse(int x) {
        boolean isNegative = false;

        if(x < 0){
            isNegative = true;
            x = -1 * x;
        }

        int rev =0;
        int prev =0;

        while(x != 0){
            int mod = x % 10;
            rev = rev * 10 + mod;

            if((rev - mod) / 10 != prev){
                return 0;
            }

            prev = rev;
            x = x/10;
        }

        return isNegative ? -1 * rev : rev;
    }
}