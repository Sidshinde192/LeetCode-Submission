class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        if(n <= 2){
            return n-1;
        }

        int left =0;
        int right =0;
        int jumps =0;

        while(right < n-1){
            int far =0;

            for(int i = left; i <= right; i++){
                far = Math.max(far, nums[i] + i);
            } 

            left = right+1;
            right = far;
            jumps++;
        }

        return jumps;
    }
}