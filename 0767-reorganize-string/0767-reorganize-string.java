class Solution {
    public String reorganizeString(String s) {
        int n = s.length();

        int [] hash = new int[26];


        for(int i =0; i< n;i++){
            char ch = s.charAt(i);
            hash[ch - 'a']++;
        }

        int max =0;
        int letter =0;

        for(int i =0; i< 26;i++){
            if(hash[i] > max){
                max = hash[i];
                letter = i;
            }
        }

        if(max > (s.length() + 1) / 2){
            return "";
        }

        char [] res = new char[n];
        int idx = 0;

        while(hash[letter]-- > 0){
            res[idx] = (char)(letter + 'a');
            idx += 2;
        }

        for(int i =0; i< hash.length;i++){
            while(hash[i]-- > 0){
                if(idx >= res.length){
                    idx = 1;
                }

                res[idx] =(char)(i + 'a');
                idx+=2;
            }
        }

        return String.valueOf(res);
    }
}