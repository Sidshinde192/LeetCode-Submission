class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;

        int sum =0;
        int max = Integer.MIN_VALUE;

        for(int num : nums){
            max = Math.max(num, max);
            sum += num;
        }

        int low = max;
        int high = sum;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(possible(mid, nums, k)){
                high = mid-1;
            }
            else{
                low = mid+1;
            }

        }

        return low;
        
    }

    public boolean possible(int num, int [] nums, int k){
        int partition = 1;

        int sum =0;

        for(int i =0; i< nums.length;i++){
            if(sum + nums[i] <= num){
                sum += nums[i];
            }
            else{
                partition++;
                sum = nums[i];
            }
        }

        return partition <= k;
    }
}