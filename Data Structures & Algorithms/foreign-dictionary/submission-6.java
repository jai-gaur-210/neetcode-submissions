class Solution {
    List<List<Character>> adj;
    public String foreignDictionary(String[] words) {
        adj = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        for(String w : words){
            for(char c : w.toCharArray()){
                set.add(c);
            }
        }
        int [] ind = new int [26];
        for(int i=0; i<26; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<words.length-1; i++){
            String a = words[i];
            String b = words[i+1];
            if(b.length() < a.length() && a.startsWith(b)){
                return "";
            }
            int k = Math.min(a.length(), b.length());
            for(int j=0; j<k; j++){
                if(a.charAt(j) != b.charAt(j)){
                    ind[b.charAt(j) - 'a']++;
                    adj.get(a.charAt(j) - 'a').add(b.charAt(j));
                    break;
                }
            }
        }
        Queue<Character> q = new LinkedList<>();
        for(char c : set){
            if(ind[c-'a'] == 0){
                q.offer(c);
            }
        }
        String ans = "";
        while(!q.isEmpty()){
            char c = q.poll();
            ans+=c;
            for(char nei : adj.get(c-'a')){
                ind[nei - 'a']--;
                if(ind[nei - 'a'] == 0){
                    q.offer(nei);
                }
            }
        }
        if(set.size() != ans.length()) return "";
        return ans;
    }
}
