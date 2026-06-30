class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        int l = 0, r = 0;
        while(r<s.length()){
            if(!set.contains(s.charAt(r))){
                set.add(s.charAt(r));
                max = Math.max(max, set.size());
                r++;
            }
            else{
                while(set.contains(s.charAt(r))){
                    set.remove(s.charAt(l));
                    l++;
                }
                set.add(s.charAt(r));
                r++;
            }
        }
        return max;
    }
}
