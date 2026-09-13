class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        Map<Character, Character> map = new HashMap<>();

        for(int i =0;i< s.length();i++){
            char og = s.charAt(i);
            char re = t.charAt(i);

            if(!map.containsKey(og)){
                if(!map.containsValue(re)){
                    map.put(og, re);
                }
                else{
                    return false;
                }
            }
            else{
                char mapped = map.get(og);
                if(mapped != re){
                    return false;
                }
            }
        }

        return true;
    }
}