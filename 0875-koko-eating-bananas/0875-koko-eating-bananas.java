class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;

        int max = 0;
        for(int pile : piles){
            max = Math.max(max, pile);
        }

        int high = max;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(canEat(piles, mid, h)){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return low;
    }

    public boolean canEat(int [] piles, int hour, int totalHr){
        int total =0;

        for(int i =0; i< piles.length;i++){
            total += Math.ceil((double) piles[i]/ (double) hour);
        }

        return total <= totalHr;
    }
}