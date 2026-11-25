class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        for(int i=0; i<n; i++){
            int l = i;
            int r = i;
            boolean flag = false;
            while(l>=0 && r<n && s.charAt(l) == s.charAt(r)){
                flag = true;
                l--; r++;
                ans++;
            }
            // if(flag){
            //     ans++;
            // }
            l = i;
            r = i+1;
            flag = false;
            while(l>=0 && r<n && s.charAt(l) == s.charAt(r)){
                flag = true;
                l--; r++;
                ans++;
            }
            // if(flag){
            //     ans++;
            // }
        }
        return ans;
    }
}
