class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for(int num : nums){
            total += num;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int target = total - x;
        int maxArrayLen = -1;
        int prefixSum =0;

        for(int i =0; i< nums.length;i++){
            prefixSum += nums[i];
            map.put(prefixSum, i);
            if(map.containsKey(prefixSum - target)){
                int currentSubarray = i - map.get(prefixSum - target);
                maxArrayLen = Math.max(maxArrayLen, currentSubarray);
            }
        }

        if(maxArrayLen == -1){
            return maxArrayLen;
        }
        return nums.length - maxArrayLen;
    }
}