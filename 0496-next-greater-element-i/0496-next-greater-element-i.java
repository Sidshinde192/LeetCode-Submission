class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;

        Map<Integer, Integer> map = new HashMap<>();

        Stack<Integer> st = new Stack<>();

        for(int i = n-1; i>=0;i--){
            int num = nums2[i];

            while(!st.isEmpty() && num >= st.peek()){
                st.pop();
            }

            if(st.isEmpty()){
                map.put(num, -1);
            }
            else{
                map.put(num, st.peek());
            }
            st.push(num);

        }

        int[] res = new int[nums1.length];

        for(int i =0; i< res.length;i++){
            res[i] = map.containsKey(nums1[i]) ? map.get(nums1[i]) : -1;
        }

        return res;
    }
}