class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max = 0;
        int diff = 0;
        int i=0, j=1;
        while(j<n){
            diff = prices[j]-prices[i];
            if(i == j){
                j++;
            }
            else if(diff<=0){
                diff = 0;
                i++;
            }
            else{
                max = Math.max(max, diff);
                j++;
            }
        }
        return max;
    }
}
