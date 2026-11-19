class Solution {
    public int countConsistent(int[] nums) {
        int count =0;

        for(int i =0; i< nums.length;i++){
            int min = nums[i];
            int num = nums[i];
            for(int j = i; j<nums.length;j++){
                num &= nums[j];
                 min = Math.min(min, nums[j]);
                if(num == min){
                    count++;
                }
                
            }
        }

        return count;
    }
}