class Solution {
    int m;
    int n;
    int [][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        for(int i=0; i<m; i++){
            dfs(i, 0, board);
            dfs(i, n-1, board);
        }
        for(int i=0; i<n; i++){
            dfs(0, i, board);
            dfs(m-1, i, board);
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == 'S'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(int i, int j, char[][] board){
        if(i<0 || j<0 || i>m-1 || j>n-1 || board[i][j] != 'O') return;
        board[i][j] = 'S';
        for(int[] d : dir){
            dfs(i+d[0], j+d[1], board);
        }
    }
}