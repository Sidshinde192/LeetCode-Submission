class Solution {
    class Pair{
        int minVal;
        int listIdx;
        int eleIdx;

        Pair(int minVal, int listIdx, int eleIdx){
            this.minVal = minVal;
            this.listIdx = listIdx;
            this.eleIdx = eleIdx;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
    (a, b) -> Integer.compare(a.minVal, b.minVal)
);

        int k = nums.size();
        int max = Integer.MIN_VALUE;

        for(int i =0; i< k;i++){
            int minval = nums.get(i).get(0);
            pq.offer(new Pair(minval, i, 0));
            max = Math.max(max, minval);
        }

        int [] minrange = new int []{0, Integer.MAX_VALUE};

        while(true){
            Pair top = pq.poll();
            int minElement = top.minVal;
            int listId = top.listIdx;
            int elementIdx = top.eleIdx;

            if(max - minElement < minrange[1] - minrange[0]){
                minrange[0] = minElement;
                minrange[1] = max;
            }

            if(elementIdx == nums.get(listId).size() - 1){
                break;
            }

            int next = nums.get(listId).get(elementIdx+1);
            max = Math.max(max, next);
            pq.offer(new Pair(next, listId, elementIdx + 1));
        }

        return minrange;
    }
}