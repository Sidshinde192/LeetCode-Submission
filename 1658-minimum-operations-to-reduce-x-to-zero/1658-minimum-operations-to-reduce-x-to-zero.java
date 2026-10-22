class Solution {
    // int minCount;
    // public void solve(int i, int j, int [] nums, int x, int count){
    //     if(x == 0){
    //       minCount = Math.min(minCount, count);
    //       return;
    //     }
    //     else if(x < 0 ||  i> j || count >= minCount){
    //         return;
    //     }
    //     else{
    //         solve(i+1, j, nums, x - nums[i], count + 1);
    //         solve(i, j-1, nums, x - nums[j], count + 1);
    //     }

    // }
    public int minOperations(int[] nums, int x) {
        // minCount = Integer.MAX_VALUE;
        // solve(0, nums.length-1, nums, x, 0);

        // if(minCount == Integer.MAX_VALUE){
        //     return -1;
        // }
        // return minCount;

        int n = nums.length;

        int sum =0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for(int i =0; i< n;i++){
            sum += nums[i];
            map.put(sum, i);
        }

        if(sum < x){
            return -1;
        }

        int longestSubarray = Integer.MIN_VALUE;
        int remaining = sum - x;
        sum =0;

        for(int i =0; i< n;i++){
            sum += nums[i];

            if(map.containsKey(sum - remaining)){
                int idx = map.get(sum - remaining);

                longestSubarray = Math.max(longestSubarray, i - idx);
            }
        }

        return longestSubarray == Integer.MIN_VALUE ? -1 : n - longestSubarray;
    }
}