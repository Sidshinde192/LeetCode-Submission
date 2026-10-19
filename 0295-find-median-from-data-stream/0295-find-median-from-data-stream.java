class MedianFinder {
    PriorityQueue<Integer> left_Max_heap;
    PriorityQueue<Integer> right_Min_heap;
    public MedianFinder() {
        left_Max_heap = new PriorityQueue<>(Collections.reverseOrder());
        right_Min_heap = new PriorityQueue<>();
        
    }
    
    public void addNum(int num) {
        if(left_Max_heap.isEmpty() || num < left_Max_heap.peek()){
            left_Max_heap.add(num);
        }
        else{
            right_Min_heap.add(num);
        }

        if(left_Max_heap.size() > right_Min_heap.size() + 1){
            right_Min_heap.add(left_Max_heap.peek());
            left_Max_heap.poll();
        }
        else if(right_Min_heap.size() > left_Max_heap.size()){
            left_Max_heap.add(right_Min_heap.peek());
            right_Min_heap.poll();
        }
    }
    
    public double findMedian() {
        if(left_Max_heap.size() == right_Min_heap.size()){
            return ((double) left_Max_heap.peek() + (double) right_Min_heap.peek())/2;
        }

        return left_Max_heap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */