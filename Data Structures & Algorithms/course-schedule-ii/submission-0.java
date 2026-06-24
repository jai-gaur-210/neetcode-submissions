class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // topological sort
        List<List<Integer>> adj = new ArrayList<>();
        int [] ind = new int[numCourses];
        int [] ans = new int[numCourses];
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
        for(int i=0; i<ind.length; i++){
            System.out.println(ind[i]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<ind.length; i++){
            if(ind[i] == 0){
                q.offer(i);
            }
        }
        int idx = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            ans[idx++] = node;
            for(int i : adj.get(node)){
                ind[i]--;
                if(ind[i] == 0){
                    q.offer(i);
                }
            }
        }
        if(idx == numCourses){
            return ans;
        }
        return new int[]{};
    }
}