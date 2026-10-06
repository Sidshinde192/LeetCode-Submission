class Solution {
    public int minAddToMakeValid(String s) {
        int bracket =0;
        int imbalance =0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                bracket++;
            }
            else if (bracket>0){
                bracket--;
            }
            else{
                imbalance++;
            }
        }
        return imbalance+bracket;
    }
}