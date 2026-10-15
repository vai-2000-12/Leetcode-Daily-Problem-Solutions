
class pair {
    int node;
    int st;
    int et;

    public pair(int node, int st, int et) {
        this.node = node;
        this.st = st;
        this.et = et;
    }
}

class Solution {
    public int minTime(int n, int[][] edges) {

        ArrayList<ArrayList<pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int st = e[2];
            int et = e[3];

            graph.get(u).add(new pair(v, st, et));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<pair> q = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.st, b.st)
        );

        dist[0] = 0;
        q.add(new pair(0, 0, 0));

        while (!q.isEmpty()) {
            pair p = q.poll();
            int currN = p.node;
            int currSt = p.st;
            int currEt = p.et;

            if (currSt > dist[currN]) {
                continue;
            }

            for (pair neigh : graph.get(currN)) {
                int next = neigh.node;
                int nSt = neigh.st;
                int nEt = neigh.et;

                int time = Math.max(currSt, nSt);

                if (time > nEt) {
                    continue;
                }

                int arrival = time + 1;

                if (arrival < dist[next]) {
                    dist[next] = arrival;
                    q.add(new pair(next, arrival, 0));
                }
            }
        }

        return dist[n - 1] == Integer.MAX_VALUE ? -1 : dist[n - 1];
    }
}
