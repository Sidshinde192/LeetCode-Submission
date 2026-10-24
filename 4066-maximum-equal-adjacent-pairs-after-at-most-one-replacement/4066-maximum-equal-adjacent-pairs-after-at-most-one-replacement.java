class Solution {
      private record Key(int a, int b) {}
    public int maxEqualAdjacentPairs(int[] nums) {
         int cnt = 0;
        int n = nums.length; 
        HashMap<Key, Integer> mp = new HashMap<>();  
        for(int i = 1; i < n; i++) {
            if(nums[i] == nums[i -1]) cnt++; 
            else {
                // add it to mp 
                Key key;  
                if(nums[i] < nums[i - 1]) {
                    key = new Key(nums[i], nums[i-1]); 
                } else key = new Key(nums[i-1], nums[i]);
                mp.put(key, mp.getOrDefault(key, 0) + 1); 
            }
        }
        int best = 0; 
        // Now the pair with most freq will give us best answer on changing 
        for(Integer val: mp.values()) {
            best = Math.max(best, val); 
        }
        return cnt + best; 
    }
}