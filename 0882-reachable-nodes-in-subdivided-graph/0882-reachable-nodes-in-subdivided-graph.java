class Pair{
    int node;
    int wt;

    public Pair(int node , int wt){
         this.node = node;
         this.wt = wt;
    }
}
class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
      //Construct the Graph:-
      ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
      
      for(int i = 0 ; i < n ; i++){
         graph.add(new ArrayList<>());
      }   

      for(int [] e : edges){
         int u = e[0];
         int v = e[1];
         int w = e[2]+1;

            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, w));
      }

      PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
      pq.add(new Pair(0, 0));

      int[] dist = new int[n];
      Arrays.fill(dist, Integer.MAX_VALUE);

      dist[0] = 0;

      while(!pq.isEmpty()){
         Pair p  = pq.poll();
         int node = p.node;
         int d = p.wt;

         if (d > dist[node])
                continue;

           for (Pair nei : graph.get(node)) {
                int adj = nei.node;
                int wt = nei.wt;

                if (d + wt < dist[adj]) {
                    dist[adj] = d + wt;
                    pq.offer(new Pair(adj, dist[adj]));
                }
            }       
      }


         int ans = 0;

        // Count reachable original nodes
        for (int i = 0; i < n; i++) {
            if (dist[i] <= maxMoves)
                ans++;
        }

        // Count reachable subdivided nodes
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int cnt = e[2];

            int left = 0;
            int right = 0;

            if (dist[u] <= maxMoves)
                left = maxMoves - dist[u];

            if (dist[v] <= maxMoves)
                right = maxMoves - dist[v];

            ans += Math.min(cnt, left + right);
        }

        return ans;
      
    }
}