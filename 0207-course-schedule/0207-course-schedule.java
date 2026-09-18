class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i =0; i< numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int [] pre : prerequisites){
            int u = pre[0];
            int v = pre[1];

            adj.get(u).add(v);
        }

        int [] indegree = new int[numCourses];

        for(int i =0; i< numCourses;i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i =0; i<numCourses;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        List<Integer> topo = new ArrayList<>();


        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);

            for(int neigh : adj.get(node)){
                indegree[neigh]--;
                if(indegree[neigh] == 0){
                    q.add(neigh);
                }
            }
        }

        if(topo.size() == numCourses){
            return true;
        }

        return false;
    }
}