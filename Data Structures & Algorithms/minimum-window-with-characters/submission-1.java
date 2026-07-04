class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        Map<Character, Integer> cnt = new HashMap<>();
        Map<Character, Integer> win = new HashMap<>();
        int l=0, min=Integer.MAX_VALUE, have = 0, need = 0, start = 0;
        for(char c : t.toCharArray()){
            cnt.put(c, cnt.getOrDefault(c, 0)+1);
        }
        need = cnt.size();
        for(int r=0; r<s.length(); r++){
            win.put(s.charAt(r), win.getOrDefault(s.charAt(r), 0)+1);
            if(cnt.containsKey(s.charAt(r)) && cnt.get(s.charAt(r)).equals(win.get(s.charAt(r)))){
                have++;
            }
            while(have == need){
                if(min > r-l+1){
                    min = r-l+1;
                    start = l;
                }
                win.put(s.charAt(l), win.get(s.charAt(l))-1);
                if(cnt.containsKey(s.charAt(l)) && win.get(s.charAt(l)) < cnt.get(s.charAt(l))){
                    have--;
                }
                l++;
            }
        } 
        return min == Integer.MAX_VALUE ? "" : s.substring(start, start+min);
    }
}
