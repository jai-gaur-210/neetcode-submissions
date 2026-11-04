class TrieNode{
    TrieNode[] arr = new TrieNode[26];
    String flag = null;
}

class Solution {
    int m,n;
    TrieNode root;
    List<String> ans;
    public List<String> findWords(char[][] board, String[] words) {
        ans = new ArrayList<>();
        m = board.length;
        n = board[0].length;
        root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.arr[idx] == null) {
                    node.arr[idx] = new TrieNode();
                }
                node = node.arr[idx];
            }
            node.flag = word;
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dfs(i, j, root, board, ans);
            }
        }
        return ans;
    }

    public void dfs(int i, int j, TrieNode root, char [][] board, List<String> ans){
        if(i<0 || j<0 || i>=m || j>=n || board[i][j] == '#' || root == null){
            return;
        }
        char c = board[i][j];
        root = root.arr[c - 'a'];
        if (root == null) {
            return;
        }
        if(root.flag != null){
            ans.add(root.flag);
            root.flag = null;
        }
        board[i][j] = '#';
        dfs(i+1, j, root, board, ans);
        dfs(i-1, j, root, board, ans);
        dfs(i, j+1, root, board, ans);
        dfs(i, j-1, root, board, ans);
        board[i][j] = c;
    }

}
