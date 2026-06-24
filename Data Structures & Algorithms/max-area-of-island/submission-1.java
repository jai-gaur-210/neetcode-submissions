class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    int cnt = helper(i, j, grid);
                    ans = Math.max(ans, cnt);
                }
            }
        }
        return ans;
    }

    public int helper(int i, int j, int[][] grid){
        if(i<0 || j<0 || i>grid.length-1 || j>grid[0].length-1 || grid[i][j]==0) return 0;
        grid[i][j] = 0;
        int a = helper(i+1, j, grid);
        int b = helper(i, j+1, grid);
        int c = helper(i-1, j, grid);
        int d = helper(i, j-1, grid);
        return 1+a+b+c+d;
    }


}