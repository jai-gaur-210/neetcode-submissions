class Solution {
    List<List<Integer>> adj;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adj = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edg : prerequisites){
            adj.get(edg[1]).add(edg[0]);
            indegree[edg[0]]++;
        }
        Queue<Integer> q = new LinkedList();
        int cnt = 0;
        for(int i=0; i<indegree.length; i++){
            if(indegree[i]<1){
                q.offer(i);
                cnt++;
            }
        }
        if(q.isEmpty()) return false;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int nei : adj.get(node)){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    q.offer(nei);
                    cnt++;
                }
            }
        }
        return cnt == numCourses;
    }
}
