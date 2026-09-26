class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        char op = '+';
        int num =0;


        for(int i =0; i< s.length();i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            }

            if((!Character.isDigit(ch) && ch != ' ') || i == s.length() -1){
                if(op == '+'){
                    st.push(num);
                }
                else if(op == '-'){
                    st.push(-1 * num);
                }
                else if(op == '*'){
                    st.push(num * st.pop());
                }
                else{
                    st.push(st.pop()/num);
                }

                num =0;
                op = ch;
            }
        }

        int sum =0;
        while(!st.isEmpty()){
            sum = sum + st.pop();
        }

        return sum;
    }
}