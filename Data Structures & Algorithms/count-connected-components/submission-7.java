class Solution {
    List<List<Integer>> adj;
    public int countComponents(int n, int[][] edges) {
        adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edg : edges){
            adj.get(edg[0]).add(edg[1]);
            adj.get(edg[1]).add(edg[0]);
        }
        int ans = 0;
        boolean[] visit = new boolean[n];
        for(int i=0; i<n; i++){
            if(!visit[i]){
                dfs(i, visit);
                ans++;
            }
        }
        return ans;
    }
    
    public void dfs(int idx, boolean[] visit){
        if(visit[idx]) return;
        visit[idx] = true;
        for(int nei : adj.get(idx)){
            dfs(nei, visit);
        }
    }
}
