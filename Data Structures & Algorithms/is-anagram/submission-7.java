class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int a [] = new int[26];
        
        for(char c: s.toCharArray()){
            a[c-'a'] += 1;
        }
        for(char c: t.toCharArray()){
            a[c-'a'] -= 1;
        }
        for(int i : a){
            if(i != 0){
                return false;
            }
        }

        return true;
    }
}
