class Solution {
    List<List<Integer>> adj;
    public int countComponents(int n, int[][] edges) {
        adj = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
            q.offer(i);
        }
        for(int[] edg : edges){
            adj.get(edg[0]).add(edg[1]);
            adj.get(edg[1]).add(edg[0]);
        }
        int ans = 0;
        boolean[] visit = new boolean[n];
        while(!q.isEmpty()){
            dfs(q.peek(), -1, q, visit);
            ans++;
        }
        return ans;
    }
    
    public void dfs(int idx, int parent, Queue<Integer> q, boolean[] visit){
        if(visit[idx]) return;
        visit[idx] = true;
        q.remove(idx);
        for(int nei : adj.get(idx)){
            if(nei == parent) continue;
            dfs(nei, idx, q, visit);
        }
    }
}
