class Pair{
    String first;
    int second;
    Pair(String _first, int _second){
        this.first = _first;
        this.second = _second;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> s = new HashSet<>();
        for(int i=0; i<wordList.size(); i++){
            s.add(wordList.get(i));
        }
        q.add(new Pair(beginWord, 1));

        while(!q.isEmpty()){
            String str = q.peek().first;
            int lvl = q.peek().second;
            q.remove();
            if(str.equals(endWord)) return lvl;
            for(int i=0; i<str.length(); i++){
                char [] arr = str.toCharArray();
                for(char ch = 'a'; ch <='z'; ch++){
                    arr[i] = ch;
                    String newStr = new String(arr);
                    if(s.contains(newStr)){
                        s.remove(newStr);
                        q.add(new Pair(newStr, lvl+1));
                    }
                }
            }
        }
        return 0;
    }
}