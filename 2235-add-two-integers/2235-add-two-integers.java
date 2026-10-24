class Solution {
    public int sum(int num1, int num2) {
        int l = -200;
        int r = 200;


        while(l <= r){
            int mid = l + (r - l)/2;

            if(mid == num1 + num2){
                return mid;
            }

            if(mid > num1 + num2){
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }

        return -1;
    }
}