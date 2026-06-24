class Solution {

        public class TrieNode{
            TrieNode [] child = new TrieNode[26];
            String word = null;
        }
        public void insert(TrieNode root, String word){
            for(char ch : word.toCharArray()){
                if(root.child[ch - 'a'] == null){
                    root.child[ch - 'a'] = new TrieNode();
                }
                root = root.child[ch - 'a'];
            }
            root.word = word;
        }
    
    public void dfs(char[][] board, int i, int j, TrieNode root, List<String> ans){
        char ch = board[i][j];
        if(ch == '#' || root.child[ch - 'a'] == null) return;
        root = root.child[ch - 'a'];
        if(root.word != null){
            ans.add(root.word);
            root.word = null;
        }
        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j, root, ans);
        if (j > 0) dfs(board, i, j - 1, root, ans);
        if (i < board.length - 1) dfs(board, i + 1, j, root, ans);
        if (j < board[0].length - 1) dfs(board, i, j + 1, root, ans);
        board[i][j] = ch;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        TrieNode root = new TrieNode();
        for(String s : words){
            insert(root , s);
        }
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                dfs(board, i, j, root, ans);
            }
        }

        return ans;
    }
    
}