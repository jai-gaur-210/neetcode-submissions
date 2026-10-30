class TrieNode{
    TrieNode arr[];
    boolean isEnd;
    public TrieNode(){
        arr = new TrieNode[26];
        isEnd = false;
    }
}

class PrefixTree {
    TrieNode root;
    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
            if(node.arr[c-'a'] == null){
                node.arr[c-'a'] = new TrieNode();
            }
            node = node.arr[c-'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
            if(node.arr[c-'a'] == null){
                return false;
            }
            node = node.arr[c-'a'];
        }
        if(node.isEnd == true){
            return true;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char c : prefix.toCharArray()){
            if(node.arr[c-'a'] == null){
                return false;
            }
            node = node.arr[c-'a'];
        }
        return true;
    }
}
