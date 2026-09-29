/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

class Solution {
    public String getHostName(String url){
        return url.split("/")[2];
    }
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String startHostName = getHostName(startUrl);
        Queue<String> q = new LinkedList<>();
        q.add(startUrl);
        Set<String> visited = new HashSet<>();
        visited.add(startUrl);

        while(!q.isEmpty()){
            String url = q.poll();

            for(String nextUrl : htmlParser.getUrls(url)){
                if(getHostName(nextUrl).equals(startHostName) && !visited.contains(nextUrl)){
                    q.add(nextUrl);
                    visited.add(nextUrl);
                }
            }
        }

        return new ArrayList<>(visited);
    }
}