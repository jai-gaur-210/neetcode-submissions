class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> s = new Stack<>();
        int max = 0;
        for(int i=0; i<=n; i++){
            int currHeight = (i == n) ? 0 : heights[i];
            while(!s.isEmpty() && currHeight < heights[s.peek()]){
                int h = heights[s.pop()];
                int ps = (s.isEmpty()) ? -1 : s.peek();
                int w = i - ps - 1;
                max = Math.max(max, h*w);
            }
            s.push(i);
        }
        return max;
    }
}