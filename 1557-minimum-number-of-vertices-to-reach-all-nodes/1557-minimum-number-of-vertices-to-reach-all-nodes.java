class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
       // Find the Indegree of the Node
       //  Get the Nodes having the indegree as 0 that 
       // will be the answer for this Question 
       // Keeping in the mind that the lst should be sorted 

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++){
             graph.add(new ArrayList<>());
        }        

        int[]indegree = new int[n];

         for(List<Integer> e : edges){
             int u = e.get(0);
             int v = e.get(1);

             graph.get(u).add(v);
             graph.get(v).add(u);

             indegree[v]++;
         }   


         for(int i = 0 ; i < n ; i++){
             if(indegree[i] == 0){
                ans.add(i);
             }
         }

         Collections.sort(ans);
         return ans;
    }
}