class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int a : asteroids){
            if(a > 0){
                st.push(a);
            }
            else{
                while(!st.isEmpty() && st.peek() > 0 && st.peek() < -a){
                    st.pop();
                }

                if(st.isEmpty() || st.peek() < 0){
                    st.push(a);
                }

                if(st.peek() == -a){
                    st.pop();
                }
            }
        }

        int [] res = new int[st.size()];
        int i = res.length-1;

        while(!st.isEmpty()){
            res[i] = st.pop();
            i--;
        }

        return res;
    }
}