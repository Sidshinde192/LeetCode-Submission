class Solution {
    class Pair{
        int node;
        int wt;

        Pair(int node, int wt){
            this.node = node;
            this.wt = wt;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();

        for(int i =0; i<= n;i++){
            adj.add(new ArrayList<>());
        }

        for(int [] time : times){
            int u = time[0];
            int v = time[1];
            int w = time[2];
            adj.get(u).add(new Pair(v, w));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        int [] dist = new int[n+1];
        Arrays.fill(dist, (int) 1e9);
        pq.add(new Pair(k, 0));
        dist[k] =0;

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int curNode = curr.node;
            int weight = curr.wt;

            for(Pair neighbour : adj.get(curNode)){
                int newNode = neighbour.node;
                int newWeight = neighbour.wt;

                if(weight + newWeight < dist[newNode]){
                    dist[newNode] = weight + newWeight;
                    pq.add(new Pair(newNode, dist[newNode]));
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for(int i =1; i<=n;i++){
            if(dist[i] == (int)1e9){
                return -1;
            }
            max = Math.max(max, dist[i]);
        }

        return max;
    }
}