class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();

        int n = graph.length;

        for(int i =0; i< n;i++){
            adj.add(new ArrayList<>());
        }

        int [] indegree = new int [n];

        for(int i =0; i< n;i++){
            for(int it : graph[i]){
                adj.get(it).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        List<Integer> safe = new ArrayList<>();

        for(int i =0; i< n;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            safe.add(node);

            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.offer(it);
                }
            }
        }

        Collections.sort(safe);
        return safe;
    }
}