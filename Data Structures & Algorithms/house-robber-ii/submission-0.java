class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        int a = help(0, n-2, nums);
        int b = help(1, n-1, nums);
        return Math.max(a, b);
    }

    public int help(int l, int r, int[] nums){
        int prev2 = 0;
        int prev1 = nums[l];
        for(int i=l+1; i<=r; i++){
            int rob = nums[i]+prev2;
            int skip = prev1;
            int curr = Math.max(rob, skip);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}