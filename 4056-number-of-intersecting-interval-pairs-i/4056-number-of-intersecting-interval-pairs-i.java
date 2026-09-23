class Solution {
    public int countIntersectingIntervals(int[][] intervals) {
        int count =0;

        Arrays.sort(intervals,(a,b)->a[0] - b[0]);
        int n = intervals.length;

        
        for(int i = 0; i< n;i++){
            int end = intervals[i][1];
            for(int j = i+1; j < n;j++){
                if(end >= intervals[j][0]){
                    count++;
                }
            }
        }

        return count;
    }
}