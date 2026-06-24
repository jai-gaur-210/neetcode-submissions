class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Start DFS from every gate (0)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    dfs(grid, i, j, 0);
                }
            }
        }
    }

    public void dfs(int[][] grid, int i, int j, int dist) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] < dist) {
            return;
        }

        grid[i][j] = dist;

        dfs(grid, i + 1, j, dist + 1);
        dfs(grid, i - 1, j, dist + 1);
        dfs(grid, i, j + 1, dist + 1);
        dfs(grid, i, j - 1, dist + 1);
    }
}
