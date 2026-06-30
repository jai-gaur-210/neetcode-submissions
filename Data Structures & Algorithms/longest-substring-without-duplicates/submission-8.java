class Solution {
    public int lengthOfLongestSubstring(String s) {
        Queue<Character> q = new ArrayDeque<>();
        int max = 0;
        for(char c : s.toCharArray()){
            if(!q.contains(c)){
                q.add(c);
                max = Math.max(max, q.size());
            }
            else{
                while(q.contains(c)){
                    q.poll();
                }
                q.add(c);
            }
        }
        return max;
    }
}
