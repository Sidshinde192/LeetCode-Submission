class Solution {
    public int countSpecialIntegers(int[] nums) {
        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i =0; i<n;i++){
           int val = nums[i];
           map.computeIfAbsent(val, k -> new ArrayList<>()).add(i);
        }

        int count =0;

        for(int val : map.keySet()){
            List<Integer> it = map.get(val);

            if(it.size() != 3){
                continue;
            }

            if(it.get(2) - it.get(1) == it.get(1) - it.get(0)){
                count++;
            }

        }

        return count;
    }
}