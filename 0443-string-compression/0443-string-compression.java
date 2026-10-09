class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int start =0;
        int index =0;

        while(start < n){
            char curr = chars[start];
            int count =0;

            while(start < n && curr == chars[start]){
                start++;
                count++;
            }
            chars[index] = curr;
            index++;

            if(count > 1){
                String count_str = Integer.toString(count);
                for(char ch : count_str.toCharArray()){
                    chars[index] = ch;
                    index++;
                }
            }
        }

        return index;
    }
}