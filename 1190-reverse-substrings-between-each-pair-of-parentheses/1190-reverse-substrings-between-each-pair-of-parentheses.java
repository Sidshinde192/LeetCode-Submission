class Solution {
    public String reverseParentheses(String s) {
         StringBuilder result = new StringBuilder(s);
        int startIdx = result.lastIndexOf("(");
        int endIdx = result.indexOf(")", startIdx);
        while(startIdx != -1)
        {
            StringBuilder sb = new StringBuilder(result.substring(startIdx    
            +1, endIdx));
            sb.reverse();
            result.replace(startIdx, endIdx+1, sb.toString());
            startIdx = result.lastIndexOf("(");
            endIdx = result.indexOf(")", startIdx);
        }
        return result.toString();
    }
}