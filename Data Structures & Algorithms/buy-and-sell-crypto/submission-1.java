class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int l = 0; int r = 1;
        int ans = 0;
        while(l<n && r<n){
            if(prices[r] > prices[l]){
                int diff = prices[r] - prices[l];
                ans = Math.max(ans, diff);
                r++;
            }
            else{
                l = r;
                r++;
            }
        }
        return ans;
    }
}
