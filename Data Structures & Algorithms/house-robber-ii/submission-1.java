class Solution {
    int n;
    public int rob(int[] nums) {
        n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        return Math.max(
            help(Arrays.copyOfRange(nums, 0, n-1)), help(Arrays.copyOfRange(nums, 1, n))
        );
    }
    public int help(int[] arr){
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for(int i=2; i<arr.length; i++){
            dp[i] = Math.max((arr[i]+dp[i-2]), dp[i-1]);
        }
        return dp[arr.length-1];
    }
}
