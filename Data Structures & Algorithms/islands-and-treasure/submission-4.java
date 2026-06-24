class Solution {

    private boolean isValid(int i, int j){
        return i>=0 && j>=0 && i<row && j<col;
    }
    private int row;
    private int col;
    public void islandsAndTreasure(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        Queue<int []> q = new LinkedList<>();
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 0){
                    q.offer(new int[]{i,j});
                }
            }
        }
        int [][] movements = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        while(!q.isEmpty()){
            for(int i=0; i<q.size(); i++){
                int parent[] = q.poll();
                int newLvl = grid[parent[0]][parent[1]];
                for(int[] mov : movements){
                    int ch_x = parent[0] + mov[0];
                    int ch_y = parent[1] + mov[1];
                    if(!isValid(ch_x, ch_y) || grid[ch_x][ch_y] != Integer.MAX_VALUE) continue;
                    grid[ch_x][ch_y] = newLvl + 1;
                    q.offer(new int[]{ch_x, ch_y});
                }
            }
        }
    }
}
