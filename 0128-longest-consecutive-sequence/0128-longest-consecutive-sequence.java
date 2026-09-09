class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        if(n == 0){
            return 0;
        }

        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        int ans =1;

        for(int it : set){

            if(!set.contains(it -1)){
                int num = it;
                int count = 1;

                while(set.contains(num + 1)){
                    num = num + 1;
                    count++;
                }

                ans = Math.max(ans, count);

            }

        }

        return ans;
    }

}