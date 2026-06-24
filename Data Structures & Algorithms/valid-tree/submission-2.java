class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int [] visited = new int[n];
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int [] i : edges){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        if(isCyclic(0, -1, adj, visited)) return false;
        for(int i : visited){
            if(i == 0) return false;
        }
        return true;
    }

    private boolean isCyclic(int node, int parent, List<List<Integer>> adj, int [] visited){
        visited[node] = 1;
        for(int k : adj.get(node)){
            if(visited[k] != 1){
                if(isCyclic(k, node, adj, visited)) return true;
            }
            else if(k != parent){
                return true;
            }
        }
        
        return false;
    }








}
