class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i : nums){
            minHeap.offer(i);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
}