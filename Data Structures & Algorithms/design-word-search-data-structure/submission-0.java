class TrieNode{
    TrieNode [] child = new TrieNode[26];
    boolean endFlag = false;
}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(node.child[ch - 'a'] == null){
                node.child[ch - 'a'] = new TrieNode();
            }
            node = node.child[ch - 'a'];
        }
        node.endFlag = true;
    }
    
    public boolean search(String word) {
       return dfs(0, root, word.toCharArray());
    }

    public boolean dfs(int idx, TrieNode root, char []word){
        if(root == null) return false;
        if(idx == word.length) return root.endFlag;
        char ch = word[idx];
        if(word[idx] == '.'){
            for(TrieNode t : root.child){
                if(t != null && dfs(idx+1, t, word)){
                    return true;
                }
            }
            return false;
        }
        else{
            return dfs(idx+1, root.child[ch - 'a'], word);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */