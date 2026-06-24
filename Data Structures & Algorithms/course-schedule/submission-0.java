class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // topological sort
        List<List<Integer>> adj = new ArrayList<>();
        int [] ind = new int[numCourses];
        List<Integer> topo = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        int k = prerequisites.length;
        for(int i=0; i<k; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        for(int i=0; i<adj.size(); i++){
            for(int j : adj.get(i)){
                ind[j]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<ind.length; i++){
            if(ind[i] == 0){
                q.offer(i);
            }
        }
        int p = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);
            for(int i : adj.get(node)){
                ind[i]--;
                if(ind[i] == 0){
                    q.offer(i);
                }
            }
        }

        if(topo.size() == numCourses){
            return true;
        }
        return false;
    }
}