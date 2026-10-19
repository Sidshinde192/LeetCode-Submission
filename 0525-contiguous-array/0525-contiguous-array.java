class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;

        for(int i =0; i< n;i++){
            if(nums[i] == 0){
                nums[i] = -1;
            }
        }

        int maxLength =0;
        int sum =0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);


        for(int i =0; i< n;i++){
            sum += nums[i];

            if(map.containsKey(sum)){
                int left = map.get(sum);
                maxLength = Math.max(maxLength, (i - left));
            }
            else{
                map.put(sum, i);
            }
        }

        return maxLength;
    }
}