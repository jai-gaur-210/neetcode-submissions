class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int []>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : times){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new int[]{v, w});
        }
        PriorityQueue<int []> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        pq.add(new int[]{k,0});

        int [] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        while(pq.size() != 0){
            int[] curr = pq.poll();
            int node = curr[0], time = curr[1];
            if(time > dist[node]) continue;

            for(int[] a : adj.get(node)){
                int nei = a[0], wt = a[1];
                if(dist[node] + wt < dist[nei]){
                    dist[nei] = dist[node] + wt;
                    pq.add(new int[]{nei, dist[nei]});
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}