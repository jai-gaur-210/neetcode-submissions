class TrieNode {
    TrieNode [] child = new TrieNode [26];
    boolean endFlag = false;
}

class PrefixTree {
    TrieNode root;
    public PrefixTree() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
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
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(node.child[ch - 'a'] == null){
                return false;
            }
            else{
                node = node.child[ch - 'a'];
            }
        }
        return node.endFlag;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char ch : prefix.toCharArray()){
            if(node.child[ch - 'a'] == null){
                return false;
            }
            else{
                node = node.child[ch - 'a'];
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
