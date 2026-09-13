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

            if(it.size() < 3){
                continue;
            }
            int len = it.get(1) - it.get(0);

            for(int i =2; i<it.size();i++){
                if(it.get(i) - it.get(i-1) == len){
                    if(i == it.size() -1){
                        count++;
                    }
                    continue;
                }
                else{
                    break;
                }
                
            }

        }

        return count;
    }
}