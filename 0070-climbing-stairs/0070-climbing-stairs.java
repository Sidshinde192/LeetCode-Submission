class Solution {
    public int climbStairs(int n) {
       if(n <= 3){
         return n;
       }

       int prev1 = 1;
       int prev = 2;

       for(int i =3; i<=n;i++){
        int curr = prev1 + prev;
        prev1 = prev;
        prev = curr;
       }

       return prev;


    }
}