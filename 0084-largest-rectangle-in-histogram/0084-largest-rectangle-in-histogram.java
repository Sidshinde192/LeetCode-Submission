class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int [] nse = findNSE(heights);
        int [] pse = findPSE(heights);

        int max = Integer.MIN_VALUE;

        for(int i =0; i< n;i++){
            int area = heights[i] * (nse[i] - pse[i] - 1);
            max = Math.max(area, max);
        }

        return max;
    }

    public int[] findNSE(int [] heights){
        int [] nse = new int[heights.length];

        Stack<Integer> st = new Stack<>();

        for(int i = heights.length -1; i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }

            if(st.isEmpty()){
                nse[i] = heights.length;
            }
            else{
                nse[i] = st.peek();
            }

            st.push(i);
        }

        return nse;
    }

    public int[] findPSE(int [] heights){
        int [] pse = new int[heights.length];

        Stack<Integer> st = new Stack<>();

        for(int i =0; i< heights.length;i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                pse[i] = -1;
            }
            else{
                pse[i] = st.peek();
            }

            st.push(i);
        }

        return pse;
    }
}