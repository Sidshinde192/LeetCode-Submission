class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        slow = square(slow);
        fast = square(square(fast));

        while(slow != fast){
            slow = square(slow);
            fast = square(square(fast));
        }

        return slow == 1;
    }

    public int square(int n){
        int sum =0;
        while(n != 0){
            int d = n % 10;
            sum += d * d;
            n = n/10;
        }

        return sum;
    }
}