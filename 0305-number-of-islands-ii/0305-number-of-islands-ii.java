class Solution {
    class DisJoint{
        List<Integer> parent = new ArrayList<>();
        List<Integer> rank = new ArrayList<>();

        public DisJoint(int n){
            for(int i =0; i< n;i++){
                parent.add(i);
                rank.add(0);
            }
        }

        public int findUpar(int node){
            if(node == parent.get(node)){
                return node;
            }

            int ulp = findUpar(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }

        public void UnionByRank(int u, int v){
            int ulp_u = findUpar(u);
            int ulp_v = findUpar(v);

            if(ulp_u == ulp_v){
                return;
            }
            if(rank.get(ulp_u) > rank.get(ulp_v)){
                parent.set(ulp_v, ulp_u);
            }
            else if(rank.get(ulp_v) > rank.get(ulp_u)){
                parent.set(ulp_u, ulp_v);
            }
            else{
                parent.set(ulp_v, ulp_u);
                rank.set(ulp_u, rank.get(ulp_u) + 1);
            }
        }
        
    }
    public boolean valid(int r, int c, int m , int n){
        return r>=0 && c>=0 && r<m && c<n;
    }
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        DisJoint ds = new DisJoint(n*m);
        int [][] visited = new int[m][n];
        int count =0;
        int [] dr ={-1,0,1,0};
        int[] dc ={0,1,0,-1};

        for(int [] pos : positions){
            int row = pos[0];
            int col = pos[1];

            if(visited[row][col] == 1){
                ans.add(count);
                continue;
            }

            visited[row][col] = 1;
            count++;

            int node = row * n + col;

            for(int k =0; k<4;k++){
                int nr = row + dr[k];
                int nc = col + dc[k];
                if(valid(nr, nc, m, n) && visited[nr][nc] == 1){
                    int adj = nr * n + nc;
                    if(ds.findUpar(node) != ds.findUpar(adj)){
                        ds.UnionByRank(node, adj);
                        count--;
                    }
                }
            }
            ans.add(count);
        }
        return ans;
    }
}