class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;

        int max = Integer.MIN_VALUE;

        for(int num : piles){
            max = Math.max(num, max);
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

    public boolean canEat(int [] piles, int mid, int h){
        int total =0;

        for(int i =0; i< piles.length;i++){
            total += Math.ceil((double)piles[i] / (double) mid);
        }

        return total <= h;
    }
}