class Pair {
    int node;
    int cost;

    Pair(int node, int cost){
        this.node = node;
        this.cost = cost;
    }
}
class Graph { 
    ArrayList<ArrayList<Pair>> graph; 

    public Graph(int n, int[][] edges) { 
        graph = new ArrayList<>(); 
 
        for(int i = 0 ; i < n ; i++){ 
            graph.add(new ArrayList<>()); 
        } 

        for(int[] edge : edges){
            graph.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }
    } 
     
    public void addEdge(int[] edge) { 
        graph.get(edge[0]).add(new Pair(edge[1], edge[2]));
    } 
     
    public int shortestPath(int node1, int node2) { 
        
        int n = graph.size();

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> a.cost - b.cost
        );

        dist[node1] = 0;
        pq.add(new Pair(node1, 0));

        while(!pq.isEmpty()){

            Pair curr = pq.poll();

            int node = curr.node;
            int cost = curr.cost;

            if(cost > dist[node]){
                continue;
            }

            if(node == node2){
                return cost;
            }

            for(Pair neigh : graph.get(node)){

                int newCost = cost + neigh.cost;

                if(newCost < dist[neigh.node]){
                    dist[neigh.node] = newCost;
                    pq.add(new Pair(neigh.node, newCost));
                }
            }
        }

        return -1;
    } 
}