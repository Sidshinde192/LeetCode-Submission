class Solution {
    class Pair{
        int num;
        int freq;

        Pair(int num, int freq){
            this.num = num;
            this.freq = freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {

        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i =0; i< n;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.freq - a.freq);

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            pq.add(new Pair(key, val));
        }

        int [] res = new int[k];

        for(int i =0; i< k;i++){
            int num = pq.poll().num;
            res[i] = num;
        }

        return res;
        
    }
}