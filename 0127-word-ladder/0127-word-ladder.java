class Solution {
    class Pair{
        String words;
        int steps;

        Pair(String words, int steps){
            this.words = words;
            this.steps = steps; 
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>();

        for(String word : wordList){
            set.add(word);
        }

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));
        set.remove(beginWord);


        while(!q.isEmpty()){
            Pair curr = q.poll();
            String currWord = curr.words;
            int step = curr.steps;

            if(currWord.equals(endWord)){
                return step;
            }

            for(int i =0; i< currWord.length();i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char [] replacement = currWord.toCharArray();
                    replacement[i] = ch;
                    String newWord = String.valueOf(replacement);

                    if(set.contains(newWord)){
                        q.offer(new Pair(newWord, step + 1));
                        set.remove(newWord);
                    }
                }
            }
        }

        return 0;
        
    }
}