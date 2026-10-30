class PrefixTree {
    List<String> list;
    public PrefixTree() {
        list = new ArrayList<>();
    }

    public void insert(String word) {
        list.add(word);
    }

    public boolean search(String word) {
        return list.contains(word);
    }

    public boolean startsWith(String prefix) {
        int n = prefix.length();
        for(String s:list){
            if(s.length()<n){
                continue;
            }
            else if(s.substring(0,n).equals(prefix)){
                return true;
            }
        }
        return false;
    }
}
