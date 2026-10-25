class Solution {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;

        int ans = helper(nums, k);

        for(int i =0; i< n;i++){
            nums[i] = -nums[i];
            ans = Math.max(ans, helper(nums, k));
            nums[i] = -nums[i];
        }

        return ans;
    }

    public int helper(int [] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int n = nums.length;
        int sum =0;
        int ans =0;

        for(int i =0; i< n;i++){
            sum += nums[i];
            int key = (sum % k + k) % k;

            if(map.containsKey(key)){
                ans = Math.max(ans, i - map.get(key));
            }else{
                map.put(key, i);
            }
        }

        return ans;
    }
}