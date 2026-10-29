class Solution {
    int m = 0;
    int n = 0;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(help(i,j, board, word, new boolean[m][n], 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean help(int i, int j, char[][] board, String word, boolean[][] visited, int idx){
        if(i>=m || j>=n || i<0 || j<0 || board[i][j] != word.charAt(idx) || visited[i][j]==true){
            return false;
        }
        if(idx == word.length()-1){
            return true;
        }
        visited[i][j] = true;
        boolean up = help(i-1,j, board, word, visited, idx+1);
        boolean right = help(i,j+1, board, word, visited, idx+1);
        boolean down = help(i+1,j, board, word, visited, idx+1);
        boolean left = help(i,j-1, board, word, visited, idx+1);
        visited[i][j] = false;
        if(up || right || down || left) return true;
        return false;
    }
}
