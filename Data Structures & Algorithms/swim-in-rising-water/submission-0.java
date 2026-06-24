class Solution {
    int [][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    int n;
    int m;
    public boolean isValid(int i, int j){
        if(i>=0 && j>=0 && i<n && j<m) return true;
        return false;
    }
    public int swimInWater(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int dist[][] = new int[n][m];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = grid[0][0];    
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> a.get(2) - b.get(2));
        pq.add(Arrays.asList(0, 0, grid[0][0]));

        while(!pq.isEmpty()){
            List<Integer> curr = pq.poll();
            int i = curr.get(0), j = curr.get(1), w = curr.get(2);
            if(i == n-1 && j == m-1) return w;
            for(int [] d : dir){
                int p = i+d[0];
                int q = j+d[1];
                if(isValid(p, q)){
                    int newTime = Math.max(w, grid[p][q]);
                    if(newTime < dist[p][q]){
                        dist[p][q] = newTime;
                        pq.add(Arrays.asList(p, q, newTime));
                    }
                    
                }
            }
        }
        return -1;
    }
}