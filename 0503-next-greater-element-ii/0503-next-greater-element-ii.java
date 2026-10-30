class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();

        int [] nge = new int[nums.length];

        for(int i = 2 * nums.length - 1; i>=0;i--){
            int idx = i % nums.length;

            while(!st.isEmpty() && nums[idx] >= st.peek()){
                st.pop();
            }

            if(i < nums.length){
                nge[i] = st.isEmpty() ? -1 : st.peek();
            }
            st.push(nums[idx]);
        }

        return nge;
    }
}