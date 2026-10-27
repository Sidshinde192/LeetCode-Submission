class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i =0; i< n;i++){
            adj.add(new ArrayList<>());
        }

        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean [] visited = new boolean[n];

        boolean found = dfs(adj, source, destination, visited);
        return found;
    }

    public boolean dfs(List<List<Integer>> adj, int curNode, int dest, boolean[] visited){
        visited[curNode] = true;

        if(curNode == dest){
            return true;
        }

        for(int neighbour : adj.get(curNode)){
            if(!visited[neighbour]){
                boolean found = dfs(adj, neighbour, dest, visited);
                if(found){
                    return true;
                }
            }
        }

        return false;
    }
}