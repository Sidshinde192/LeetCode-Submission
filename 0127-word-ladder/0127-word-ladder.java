class Solution {
    class Pair{
        String word;
        int steps;
        Pair(String word, int steps){
            this.word = word;
            this.steps = steps;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();

        for(String word : wordList){
            set.add(word);
        }
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(beginWord, 1));
        set.remove(beginWord);

        while(!q.isEmpty()){
            Pair curr = q.poll();
            String currWord = curr.word;
            int step = curr.steps;

            if(currWord.equals(endWord)){
                return step;
            }


            for(int i =0; i< currWord.length();i++){
                for(char c='a'; c<='z'; c++){
                    char [] replacement = currWord.toCharArray();
                    replacement[i] = c;

                    String newWord = String.valueOf(replacement);
                    if(set.contains(newWord)){
                        q.add(new Pair(newWord, step+1));
                        set.remove(newWord);
                    }
                }
            }
        }

        return 0;
    }
}