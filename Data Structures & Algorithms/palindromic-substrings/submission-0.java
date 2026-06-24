class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        if(n == 0 || n == 1) return n;
        int cnt = 1;
        for(int i=1; i<n; i++){
            int l = i;
            int h = i;
            while(s.charAt(l) == s.charAt(h)){
                cnt++;
                l--; h++;
                if(l == -1 || h == n) break;
            }
            l = i-1;
            h = i;
            while(s.charAt(l) == s.charAt(h)){
                cnt++;
                l--; h++;
                if(l == -1 || h == n) break;
            }
        }
        return cnt;
    }
}