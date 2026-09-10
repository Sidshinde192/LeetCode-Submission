class Solution {
    public int sum(int num1, int num2) {
        int l = -200;
        int r = 200;

        while(l < r){
            int mid = (l + r)/2;

            if(mid == num1 + num2){
                return mid;
            }

            if(mid < num1 + num2){
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }

        return l;
    }
}