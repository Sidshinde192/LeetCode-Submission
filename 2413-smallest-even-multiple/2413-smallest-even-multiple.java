class Solution {
    public int smallestEvenMultiple(int n) {
        int ans;

        for(int i = n; i< 1000;i++){
            if(i%2 == 0 && i%n ==0){
                ans = i;
                return ans;
            }
        }
        return -1;
    }
}