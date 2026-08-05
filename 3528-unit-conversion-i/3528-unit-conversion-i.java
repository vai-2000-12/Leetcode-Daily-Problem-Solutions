class Pair {
    int node;
    long value;

    public Pair(int node, long value) {
        this.node = node;
        this.value = value;
    }
}

class Solution {

    static final int MOD = 1000000007;

    public int[] baseUnitConversions(int[][] conversions) {

        int n = conversions.length + 1;

        // Construct the Graph
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] con : conversions) {
            int u = con[0];
            int v = con[1];
            int w = con[2];

            graph.get(u).add(new Pair(v, w));
        }

        boolean[] visited = new boolean[n];
        int[] ans = new int[n];

        BFS(0, visited, graph, ans);

        return ans;
    }

    public void BFS(int start, boolean[] visited,
                    ArrayList<ArrayList<Pair>> graph,
                    int[] ans) {

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(start, 1));
        visited[start] = true;
        ans[start] = 1;

        while (!q.isEmpty()) {

            Pair p = q.poll();

            int node = p.node;
            long currVal = p.value;

            for (Pair nbr : graph.get(node)) {

                if (!visited[nbr.node]) {

                    visited[nbr.node] = true;

                    long nextVal = (currVal * nbr.value) % MOD;
                    ans[nbr.node] = (int) nextVal;

                    q.add(new Pair(nbr.node, nextVal));
                }
            }
        }
    }
}