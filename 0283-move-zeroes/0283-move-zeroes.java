class Solution {
    public void moveZeroes(int[] nums) {
        int idx = -1;

        for(int i =0; i< nums.length;i++){
            if(nums[i] == 0){
                idx = i;
                break;
            }
        }

        if(idx == -1){
            return;
        }

        for(int i = idx+1; i< nums.length;i++){
            if(nums[i] != 0){
                int temp = nums[idx];
                nums[idx] = nums[i];
                nums[i] = temp;
                idx++;

            }
        }
    }
}