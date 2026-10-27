class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> bmp = new HashMap<>();

        for(String str : strs){
            Map<Character, Integer> freq = new HashMap<>();

            for(char ch : str.toCharArray()){
                freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            }

            if(!bmp.containsKey(freq)){
                List<String> temp = new ArrayList<>();
                temp.add(str);
                bmp.put(freq, temp);
            }
            else{
                List<String> temp = bmp.get(freq);
                temp.add(str);
            }
        }

        List<List<String>> ans = new ArrayList<>();

        for(List<String> result : bmp.values()){
            ans.add(result);
        }

        return ans;
    }
}