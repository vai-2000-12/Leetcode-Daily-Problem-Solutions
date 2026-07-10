class Pair{
    int node;
    int time;

    public Pair(int node , int time){
         this.node = node;
         this.time = time;
    }
}
class Solution {
    int ans = 0;
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        int n = values.length;
        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>());
        }        

        for(int[]e : edges){
            int u = e[0];
            int v = e[1];
            int time = e[2];

            graph.get(u).add(new Pair(v, time));
            graph.get(v).add(new Pair(u, time));
        }

        int[] visited = new int[n];
        visited[0] = 1; // Starting node visited
        ans = values[0];

        dfs(0, 0, values[0], visited, graph, values, maxTime);

        return ans;
    }
    private void dfs(int node, int currTime, int currQuality,
                     int[] visited,
                     ArrayList<ArrayList<Pair>> graph,
                     int[] values,
                     int maxTime) {

        if (node == 0) {
            ans = Math.max(ans, currQuality);
        }

        for (Pair p : graph.get(node)) {

            int next = p.node;
            int travelTime = p.time;

            if (currTime + travelTime > maxTime)
                continue;

            int newQuality = currQuality;

            if (visited[next] == 0) {
                newQuality += values[next];
            }

            visited[next]++;

            dfs(next,
                currTime + travelTime,
                newQuality,
                visited,
                graph,
                values,
                maxTime);

            visited[next]--;
        }
    }
}