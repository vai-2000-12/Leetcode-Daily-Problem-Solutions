class Solution {
    public int numberOfComponents(int[][] properties, int k) {
       int V = properties.length;
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
       for(int i = 0 ; i < V; i++){
           for(int j= i+1 ; j < V ; j++){
              if(hasDistinctElements(properties[i], properties[j]) >=k ){
                  graph.get(i).add(j);
                  graph.get(j).add(i);
              }
           }
       }

      boolean[]visited = new boolean[V];
      int components = 0;

      for(int i = 0 ; i < V ; i++){
         if(!visited[i]){
             components++;
             BFS(i , graph, visited);
         }
      }

      return components;
    }
    
    public int hasDistinctElements(int[] a , int[]b){
          HashSet<Integer> set = new HashSet<>();
           for (int num : a) {
            set.add(num);
        }

        int count = 0;
        HashSet<Integer> used = new HashSet<>();

        for (int num : b) {
            if (set.contains(num) && !used.contains(num)) {
                count++;
                used.add(num);
            }
        }

        return count;
    }
   
    public void BFS(int src, List<List<Integer>> graph, boolean[]visited){
         
        Queue<Integer> q = new LinkedList<>();

        q.offer(src);
        visited[src] = true;

        while (!q.isEmpty()) {

            int node = q.poll();

            for (int next : graph.get(node)) {

                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}