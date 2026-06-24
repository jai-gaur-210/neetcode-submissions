class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int [] dist = new int[n+1];
        for(int i=2; i<n+1; i++){
            dist[i] = Math.min((cost[i-2]+dist[i-2]) , (cost[i-1]+dist[i-1]));
        }
        return dist[n];
    }
}