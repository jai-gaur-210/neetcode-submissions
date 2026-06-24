class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        for(String str : words){
            for(char ch : str.toCharArray()){
                indegree.put(ch, 0);
            }
        }
        for(int i=1; i<words.length; i++){
            String s1 = words[i-1];
            String s2 = words[i];
            if(s1.length() > s2.length() && s1.startsWith(s2)) return "";

            int len = Math.min(s1.length(), s2.length());
            for(int j=0; j<len; j++){
                char a = s1.charAt(j);
                char b = s2.charAt(j);
                if(a != b){
                    graph.putIfAbsent(a, new HashSet<>());
                    if(graph.get(a).add(b)){
                        indegree.put(b, indegree.get(b)+1);
                    }
                    break;
                }
            }
        }
        Queue<Character> q = new LinkedList<>();
        for(char ch : indegree.keySet()){
            if(indegree.get(ch) == 0){
                q.offer(ch);
            }
        }
        
        String ans = "";
        while(!q.isEmpty()){
            char curr = q.remove();
            // System.out.println(curr);
            ans += curr;
            if(graph.containsKey(curr)){
                for(char ch : graph.get(curr)){
                    indegree.put(ch, indegree.get(ch)-1);
                    if(indegree.get(ch) == 0){
                        q.offer(ch);
                    }
                }
            }
            
        }
        if (ans.length() < indegree.size()) {
            return "";
        }
        return ans;

    }
}
