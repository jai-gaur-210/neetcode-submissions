class Solution {
    private int row;
    private int col;
    private boolean isValid(int i, int j){
        return i>=0 && j>=0 && i<row && j<col;
    }

    public int orangesRotting(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        int totalO = 0;
        int rottenO = 0;
        Queue<int []> q = new LinkedList<>();
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] != 0){
                    totalO++;
                }
                if(grid[i][j] == 2){
                    rottenO++;
                    q.offer(new int[]{i,j});
                }
            }
        }
        
        int [][] movements = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        int min = 0;
        while(!q.isEmpty()){
            boolean flag = false;
            int size = q.size();
            for(int i=0; i<size; i++){
                int parent[] = q.poll();
                for(int [] mov : movements){
                    int ch_x = parent[0] + mov[0];
                    int ch_y = parent[1] + mov[1];
                    if(isValid(ch_x, ch_y) && grid[ch_x][ch_y] == 1){
                        grid[ch_x][ch_y] = 2;
                        rottenO++;
                        q.offer(new int[]{ch_x,ch_y});
                        flag = true;
                    }
                    
                }
            }
            if(flag) min++;
        }
        if(totalO == rottenO) return min;
        return -1;
    }
}