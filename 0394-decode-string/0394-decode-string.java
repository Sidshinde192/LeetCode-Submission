class Solution {
    public String decodeString(String s) {
        Stack<Integer> num = new Stack<>();
        Stack<String> word = new Stack<>();
        StringBuilder sb = new StringBuilder();


        for(int i =0; i< s.length();i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                int dig = 0;

                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    dig = dig * 10 + s.charAt(i) - '0';
                    i++;
                }

                i--;
                num.push(dig);
            }
            else if(ch == '['){
                word.push(sb.toString());
                sb.setLength(0);
            }
            else if(ch == ']'){
                int val = num.pop();
                String temp = sb.toString();
                sb.setLength(0);
                sb.append(word.pop());
                sb.append(temp.repeat(val));
            }
            else{
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}