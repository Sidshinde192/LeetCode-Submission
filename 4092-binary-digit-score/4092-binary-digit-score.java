class Solution {
    public int calculateScore(int a, int b) {
        String s1 = Integer.toBinaryString(a);
        String s2 = Integer.toBinaryString(b);

        int s1count = 0;
        int s2count =0;

        for(int i =0; i< s1.length();i++){
            if(s1.charAt(i) == '1'){
                s1count++;
            }
        }

        for(int i = 0; i< s2.length();i++){
            if(s2.charAt(i) == '1'){
                s2count++;
            }
        }

        if(s1count > s2count || s1count == s2count){
            return s1count * s2count;
        }

        return Math.abs(s2count/s1count);
    }
}