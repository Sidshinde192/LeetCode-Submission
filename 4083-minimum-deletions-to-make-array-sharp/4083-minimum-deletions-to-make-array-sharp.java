class Solution {
    public int minDeletions(int[] nums) {
        int prev = nums[0];
        int deletion =0;

        for(int i =1; i< nums.length;i++){
            if(prev == nums[i]){
                deletion++;
            }
            prev = nums[i];
        }

        return deletion;
    }
}