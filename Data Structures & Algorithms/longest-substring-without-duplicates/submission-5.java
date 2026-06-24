class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0 || n == 1) return n;
        int r = 0; int l=0;
        int res = 0;
        Set<Character> set = new HashSet<>();
        while(l<n && r<n){
            if(!set.contains(s.charAt(r))){
                set.add(s.charAt(r));
                r++;
                res = Math.max(res, set.size());
            }
            else{
                set.remove(s.charAt(l));
                l++;
            }
        // pwwkew
        // dvdf
        }
        return res;
    }
}
