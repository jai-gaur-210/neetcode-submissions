class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] f : flights) adj.get(f[0]).add(new int[]{f[1], f[2]});

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0, 0});
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int u = cur[0], cost = cur[1], stops = cur[2];

            if (stops > k) continue;

            for (int[] nei : adj.get(u)) {
                int v = nei[0], w = nei[1];
                if (cost + w < dist[v]) {
                    dist[v] = cost + w;
                    q.add(new int[]{v, dist[v], stops + 1});
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
