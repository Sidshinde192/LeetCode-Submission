class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int max =0;

        for(int i =0; i<=n;i++){
            while(!st.isEmpty() && (i == n || heights[st.peek()] >= heights[i])){
                int height = heights[st.peek()];
                st.pop();
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();

                max = Math.max(max, height * (nse - pse - 1));


            }
            st.push(i);
        }

        return max;
    }
}