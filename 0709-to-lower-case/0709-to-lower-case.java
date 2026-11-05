class Solution {
    public String toLowerCase(String s) {
        StringBuilder ans = new StringBuilder();

        int n = s.length();

        if(n == 0){
            return ans.toString();
        }

        for(int i =0; i< n;i++){
            char ch = s.charAt(i);

            ans.append(Character.toLowerCase(ch));
        }

        return ans.toString();
    }
}