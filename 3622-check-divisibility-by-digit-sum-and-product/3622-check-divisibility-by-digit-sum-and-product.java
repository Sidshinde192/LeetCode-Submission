class Solution {
    public boolean checkDivisibility(int n) {
        
        int sum = getSum(n);
        int product = getProduct(n);
        int totalSum = sum + product;

        return n % totalSum == 0;
    }

    public int getSum(int n){
        int sum =0;

        while(n != 0){
            int d = n % 10;
            sum += d;
            n = n/10;
        }

        return sum;
    }

    public int getProduct(int n){
        int pro = 1;
        while(n != 0){
            int d = n % 10;
            pro *= d;
            n = n/10;
        }
        return pro;
    }
}