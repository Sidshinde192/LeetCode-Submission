class MinStack {
    Stack<Long> st;
    Long min;

    public MinStack() {
        st = new Stack<>();
        min = Long.MAX_VALUE;
        
    }
    
    public void push(int value) {
        Long val = Long.valueOf(value);

        if(st.isEmpty()){
            st.push(val);
            min = val;
            
        }
        else{
            if(val >= min){
                st.push(val);
            }
            else{
                st.push(2 * val - min);
                min = val;
                
            }
        }
        
    }
    
    public void pop() {
        if(st.isEmpty()){
            return;
        }

        Long x = st.pop();

        if(x < min){
            min = 2 * min - x;
        }
        
    }
    
    public int top() {
        if(st.isEmpty()){
            return -1;
        }

        Long x = st.peek();

        if(x < min){
            return min.intValue();
        }

        return x.intValue();
        
    }
    
    public int getMin() {

        return min.intValue();
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */