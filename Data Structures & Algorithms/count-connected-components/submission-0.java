class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int [] visited = new int [n];
        int cnt = 0;
        for(int i=0 ;i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr : edges){
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }
        for(int i=0; i<n; i++){
            if(visited[i] != 1){
                cnt++;
                dfs(i, adj, visited);
            }
        }
        return cnt;
    }

    private void dfs(int node, List<List<Integer>> adj, int [] visited){
        visited[node] = 1;
        for(int k : adj.get(node)){
            if(visited[k] == 0){
                dfs(k, adj, visited);
            }
        }
    }
}
