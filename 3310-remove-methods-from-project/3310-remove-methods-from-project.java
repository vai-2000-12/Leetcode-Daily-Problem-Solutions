class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        
        //Constructed the Diected Graph:-
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < n ;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] inno : invocations){
            int u = inno[0];
            int v = inno[1];

            graph.get(u).add(v);
        }
    
    
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        BFS(k , visited , graph);

         for (int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];

            if (!visited[u] && visited[v]) {
                List<Integer> ans = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }

                return ans;
            }
        }

        // Return remaining methods
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ans.add(i);
            }
        }

        return ans;

    }

    public void BFS(int node , boolean[]visited, ArrayList<ArrayList<Integer>>graph){
         Queue<Integer> q= new LinkedList<>();
         q.add(node);
         visited[node] = true;

         while(!q.isEmpty()){
             int curr = q.poll();

             for(int neigh : graph.get(curr)){
                  if(!visited[neigh]){
                      visited[neigh] = true;
                      q.add(neigh);
                  }
             }
         }    
    }
}