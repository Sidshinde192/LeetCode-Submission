class ProductOfNumbers {
    List<Integer> l;
    public ProductOfNumbers() {
        l = new ArrayList<>();
    }
    
    public void add(int num) {
        if(num == 0){
            l.clear();
            return;
        }
        int prev = l.size()==0 ? 1 : l.get(l.size()-1);
        l.add(prev * num);
    }
    
    public int getProduct(int k) {
        int n = l.size();
        if(n < k){
            return 0;
        }
        else if(k==n){
            return l.get(n-1);
        }
        else{
            return (l.get(n-1) / l.get(n-1-k));
        }
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */