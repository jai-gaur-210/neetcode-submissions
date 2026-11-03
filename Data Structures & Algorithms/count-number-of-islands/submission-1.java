class Solution {
    int m,n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int cnt = 0;
        boolean visited[][] = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1' && !visited[i][j] && help(i, j, grid, visited)){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public boolean help(int i, int j, char[][] grid, boolean[][] visited){
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j] == '0' || visited[i][j]){
            return false;
        }
        visited[i][j] = true;
        help(i+1, j, grid, visited);
        help(i-1, j, grid, visited);
        help(i, j+1, grid, visited);
        help(i, j-1, grid, visited);
        return true;
    }
}
