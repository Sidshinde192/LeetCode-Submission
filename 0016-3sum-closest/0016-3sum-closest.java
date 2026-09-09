class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];

        if(res == target){
            return res;
        }

        for(int i =0; i< nums.length;i++){
            int j = i+1;
            int k = nums.length-1;

            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];

                if(Math.abs(target - sum) < Math.abs(target - res)){
                    res = sum;
                }
                else if(sum == target){
                    return target;
                }
                else if(sum > target){
                    k--;
                }
                else{
                    j++;
                }   
            }

           
        }

        return res;
    }
}