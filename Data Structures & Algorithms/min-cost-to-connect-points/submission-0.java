class Solution {
    public int minCostConnectPoints(int[][] points) {
        boolean vis [] = new boolean[points.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.add(new int[]{0,0});

        int cost = 0;
        while(!pq.isEmpty()){
            int []curr = pq.poll();
            int node = curr[1];
            int w = curr[0];
            if(vis[node]) continue;
            vis[node] = true;
            cost += w;
            for(int i=0; i<points.length; i++){
                if(!vis[i]){
                    int dist = Math.abs(points[node][0] - points[i][0]) + Math.abs(points[node][1] - points[i][1]);
                    pq.add(new int[]{dist, i});
                }
            }
        }
        return cost;
    }
}