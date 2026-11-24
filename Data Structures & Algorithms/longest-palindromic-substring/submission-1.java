class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int max = Integer.MIN_VALUE;
        String ans = "";
        for(int i=0; i<n; i++){
            int l=i, r=i;
            boolean flag = false;
            while(l>=0 && r<n && s.charAt(l) == s.charAt(r)){
                l--;
                r++;
                flag = true;
            }
            if(flag && r-l-1 > max){
                max = r-l-1;
                ans = s.substring(l+1, l+1+max);
            }
            l=i; 
            r=i+1;
            flag = false;
            while(l>=0 && r<n && s.charAt(l) == s.charAt(r)){
                l--;
                r++;
                flag = true;
            }
            if(flag && r-l-1 > max){
                max = r-l-1;
                ans = s.substring(l+1, l+1+max);
            }
        }    
        return ans;
    }
}
