class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean dp[] = new boolean[n+1];
        dp[0] = true;
        Set<String> set = new HashSet<>();
        int maxL = Integer.MIN_VALUE;
        for(String str : wordDict){
            maxL = Math.max(maxL, str.length());
            set.add(str);
        }
        for(int i=1; i<=n; i++){
            for(int j=i-1; j>=0 && j>=i-maxL; j--){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }
}
