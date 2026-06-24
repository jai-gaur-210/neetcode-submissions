class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        int j = 1;
        while(j<n){
            int i = 0;
            while(i<j){
                if(nums[i] < nums[j]){
                    dp[j] = Integer.max(dp[j], 1+dp[i]);
                }
                i++;
            }
            max = Math.max(max, dp[j]);
            j++;
        }
        return max;
    }
}
