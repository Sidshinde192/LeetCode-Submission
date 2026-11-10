class Solution {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        List<List<String>> ans = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();


        int n = s1.length();
        

        int i =0; 
        int j =0;

        while(i < n && j < n){

            if(s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            }
            else{
                while((i < n && j < n) && s1.charAt(i) != s2.charAt(j)){
                    sb.append(s1.charAt(i));
                    sb2.append(s2.charAt(j));
                    i++;
                    j++;
                }
                ans.add(new ArrayList<>(List.of(sb.toString(), sb2.toString())));

                sb.setLength(0);
                sb2.setLength(0);
            }

        }

        return ans;
        
    }
}