class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        int [] visited = new int[n];
        int province =0;

        for(int i =0; i< n;i++){
            if(visited[i] == 0){
                dfs(isConnected, i, visited);
                province++;
            }
        }

        return province;
    }

    public void dfs(int [][] isConnected, int node, int [] visited){
        visited[node] = 1;

        for(int i =0; i< isConnected.length;i++){
            if(isConnected[node][i] == 1 && visited[i] == 0){
                dfs(isConnected, i, visited);
            }
        }
    }
}