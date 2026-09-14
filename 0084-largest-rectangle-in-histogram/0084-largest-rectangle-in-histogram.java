class Solution {
    public int largestRectangleArea(int[] histo) {
        int n = histo.length;

        Stack<Integer> st = new Stack<>();
        int max =0;

        for(int i =0; i<=n;i++){
            while(!st.isEmpty() && (i==n || histo[st.peek()] >= histo[i])){
                int height = histo[st.peek()];
                st.pop();

                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();

                max = Math.max(max, height * (nse - pse -1));
            }
            st.push(i);
        }

        return max;
    }
}