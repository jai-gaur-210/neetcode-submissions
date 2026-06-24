class Solution {
    int [][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    int row;
    int col;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if(heights == null) return res;
        row = heights.length;
        col = heights[0].length;
        boolean [][] pacific = new boolean[row][col];
        boolean [][] atlantic = new boolean[row][col];
        for(int i=0; i<col; i++){
            dfs(heights, 0, i, Integer.MIN_VALUE, pacific);
        }
        for(int i=0; i<row; i++){
            dfs(heights, i, 0, Integer.MIN_VALUE, pacific);
        }
        for(int i=row-1; i>=0; i--){
            dfs(heights, i, col-1, Integer.MIN_VALUE, atlantic);
        }
        for(int i=col-1; i>=0; i--){
            dfs(heights, row-1, i, Integer.MIN_VALUE, atlantic);
        }
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    public void dfs(int [][] matrix, int i, int j, int prev, boolean [][] ocean){
        if(i<0 || j<0 || i>row-1 || j>col-1 || ocean[i][j] || matrix[i][j] < prev){
            return;
        }
        ocean[i][j] = true;
        for(int [] dir : dir){
            dfs(matrix, i+dir[0], j+dir[1], matrix[i][j], ocean);
        }
    }
}