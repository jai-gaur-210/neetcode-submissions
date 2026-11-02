class TrieNode{
    boolean isEnd;
    TrieNode arr[];
    public TrieNode(){
        arr = new TrieNode[26];
        isEnd = false;
    }
}

class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
            if(node.arr[c-'a']==null){
                node.arr[c-'a'] = new TrieNode();
            }
            node = node.arr[c-'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        return help(0, node, word.toCharArray());
    }

    public boolean help(int idx, TrieNode node, char[] word){
        if(node == null) return false;
        if(idx == word.length) return node.isEnd;
        char c = word[idx];
        if(c == '.'){
            for(TrieNode t : node.arr){
                if(help(idx+1, t, word)){
                    return true;
                }
            }
            return false;
        }
        else{
            return help(idx+1, node.arr[c-'a'], word);
        }
    }
}
