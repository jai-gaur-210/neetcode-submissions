class Solution {
    int r = 0;
    int c = 0;

    public boolean exist(char[][] board, String word) {
        r = board.length;
        c = board[0].length;
        boolean[][] visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (backtrack(i, j, board, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(int a, int b, char[][] board, String word, int k, boolean[][] visited) {
        if (k == word.length()) return true;

        if (a < 0 || b < 0 || a >= r || b >= c || board[a][b] != word.charAt(k) || visited[a][b]) {
            return false;
        }

        visited[a][b] = true;

        boolean found = backtrack(a, b + 1, board, word, k + 1, visited) ||
                        backtrack(a + 1, b, board, word, k + 1, visited) ||
                        backtrack(a, b - 1, board, word, k + 1, visited) ||
                        backtrack(a - 1, b, board, word, k + 1, visited);

        // Backtrack
        visited[a][b] = false;

        return found;
    }
}
