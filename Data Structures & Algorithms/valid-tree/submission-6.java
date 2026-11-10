class Solution {
    List<List<Integer>> adj;
    public boolean validTree(int n, int[][] edges) {
        adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edg : edges){
            adj.get(edg[0]).add(edg[1]);
            adj.get(edg[1]).add(edg[0]);
        }
        boolean[] visit = new boolean[n];
        if(!dfs(0, -1, visit)){
            return false;
        }
        for(boolean value : visit){
            if(!value) return false;
        }
        return true;
    }

    public boolean dfs(int idx, int parent, boolean[] visit){
        if(visit[idx]) return false;
        visit[idx] = true;

        for(int nei : adj.get(idx)){
            if(nei == parent){
                continue;
            }
            if(!dfs(nei, idx, visit)) return false;
        }
        return true;
    }
}
