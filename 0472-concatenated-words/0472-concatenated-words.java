class Solution {
    Map<String, Boolean> map;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        int n = words.length;
        map = new HashMap<>();

        Set<String> set = new HashSet<>();

        for(String word : words){
            set.add(word);
        }
        List<String> ans = new ArrayList<>();

        for(int i =0; i< n;i++){
            String word = words[i];

            if(isConcatenated(word, set)){
                ans.add(word);
            }

        }

        return ans;
        
    }

    public boolean isConcatenated(String word, Set<String> set){
        int l = word.length();
        if(map.containsKey(word)){
            return map.get(word);
        }
        for(int i =0; i< l;i++){
            String prefix = word.substring(0, i+1);
            String suffix = word.substring(i+1);

            if((set.contains(prefix) && set.contains(suffix)) || (set.contains(prefix) && isConcatenated(suffix, set))){
                map.put(word,true);
                return true;
            }

        }

        map.put(word,false);
        return false;
    }
}