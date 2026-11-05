class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;

        int left =0;
        int right =0;

        int maxLength =0;

        Map<Integer, Integer> map = new HashMap<>();

        while(right < n){
            int num = fruits[right];

            map.put(num, map.getOrDefault(num, 0) + 1);

            if(map.size() > 2){
                int leftNum = fruits[left];

                map.put(leftNum, map.get(leftNum) - 1);

                if(map.get(leftNum) == 0){
                    map.remove(leftNum);
                }

                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}