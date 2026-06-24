class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0; i<k; i++){
            minHeap.offer(nums[i]);
        }
        for(int i=k; i<n; i++){
            if(nums[i] > minHeap.peek()){
                minHeap.offer(nums[i]);
            }
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }

}