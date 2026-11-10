class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int start =0;
        int index =0;

        while(start < n){
            char ch = chars[start];
            int count =0;

            while(start< n && ch == chars[start]){
                start++;
                count++;
            }

            chars[index] = ch;
            index++;

            if(count > 1){
                String count_str = Integer.toString(count);

                for(char num : count_str.toCharArray()){
                    chars[index] = num;
                    index++;
                }
            }
        }

        return index;
        
    }
}