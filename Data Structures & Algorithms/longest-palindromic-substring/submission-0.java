class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n <=1) return s;
        int max = 1;
        String ans = "";
        for(int i=1; i<s.length(); i++){
            int l = i;
            int h = i;
            boolean f = false;
            while(s.charAt(l) == s.charAt(h)){
                f = true;
                l--; h++;
                if(l == -1 || h == s.length()) break;
            }
            if(f && max < h+1-l){
                max = h+1 - l;
                ans = s.substring(l+1, h);
            }
            l = i-1;
            h = i;
            f= false;
            while(s.charAt(l) == s.charAt(h)){
                f = true;
                l--; h++;
                if(l == -1 || h == s.length()) break;
            }
            if(f && max < h+1-l){
                max = h+1 - l;
                ans = s.substring(l+1, h);
            }
        }
        return ans;
    }
}
