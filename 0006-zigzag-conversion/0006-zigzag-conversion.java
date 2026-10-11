class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }

        StringBuilder ans = new StringBuilder();

        for(int i =0; i< numRows; i++){
            int idx = i;
            int deltaSouth = 2 * (numRows - 1- i);
            int deltaNorth = 2 * i;
            boolean goingDown = true;


            while(idx < s.length()){
                ans.append(s.charAt(idx));
                if(i == 0){
                    idx += deltaSouth;
                }
                else if(i == numRows - 1){
                    idx += deltaNorth;
                }
                else{
                    if(goingDown){
                        idx += deltaSouth;
                    }
                    else{
                        idx += deltaNorth;
                    }

                    goingDown = !goingDown;
                }
            }
        }

        return ans.toString();
    }
}