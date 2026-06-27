class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int max = Integer.MIN_VALUE;
        int l=0, r=n-1;
        while(l<r){
            int height = Math.min(heights[l], heights[r]);
            int width = r-l;
            max = Math.max(max, height*width);
            if(heights[l]<heights[r]) l++;
            else r--;
        }
        return max;

    }
}
