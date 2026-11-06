class Solution {
    int m,n;
    int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for(int i=0; i<n; i++){
            dfs(0, i, Integer.MIN_VALUE, pacific, heights);
            dfs(m-1, i, Integer.MIN_VALUE, atlantic, heights);
        }
        for(int i=0; i<m; i++){
            dfs(i, 0, Integer.MIN_VALUE, pacific, heights);
            dfs(i, n-1, Integer.MIN_VALUE, atlantic, heights);
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }

    public void dfs(int i, int j, int prev, boolean[][] ocean, int[][] heights){
        if(i<0 || j<0 || i>=m || j>= n || prev>heights[i][j] || ocean[i][j]){
            return;
        }
        ocean[i][j] = true;
        for(int[] dir : dir){
            dfs(i+dir[0], j+dir[1], heights[i][j], ocean, heights);
        }
    }
    
}
