class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;

        if(n==0){
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int left =0;
        int max =0;

        for(int right =0; right < n;right++){
            int num = fruits[right];

            map.put(num, map.getOrDefault(num, 0) + 1);

            if(map.size() > 2){
                int leftnum = fruits[left];

                map.put(leftnum, map.get(leftnum) -1);

                if(map.get(leftnum) == 0){
                    map.remove(leftnum);

                }
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}