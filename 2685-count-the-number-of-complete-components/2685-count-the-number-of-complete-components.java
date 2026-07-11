import java.util.*;

class Solution {

    public int countCompleteComponents(int n, int[][] edges) {

        // Construct the graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        ArrayList<Boolean> isCompletelyConn = new ArrayList<>();

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                ArrayList<Integer> component = BFS(i, graph, visited);

                boolean complete = true;
                int size = component.size();

                for (int node : component) {

                    if (graph.get(node).size() != size - 1) {
                        complete = false;
                        break;
                    }
                }

                isCompletelyConn.add(complete);
            }
        }

        int count = 0;

        for (boolean x : isCompletelyConn) {
            if (x)
                count++;
        }

        return count;
    }

    public ArrayList<Integer> BFS(int src,
                                  ArrayList<ArrayList<Integer>> graph,
                                  boolean[] visited) {

        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> component = new ArrayList<>();

        q.offer(src);
        visited[src] = true;

        while (!q.isEmpty()) {

            int node = q.poll();
            component.add(node);

            for (int neigh : graph.get(node)) {

                if (!visited[neigh]) {
                    visited[neigh] = true;
                    q.offer(neigh);
                }
            }
        }

        return component;
    }
}