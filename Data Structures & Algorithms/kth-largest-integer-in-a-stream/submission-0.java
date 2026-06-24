class KthLargest {

    PriorityQueue<Integer> minHeap;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        for(int i : nums){
            add(i);
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);

        if(minHeap.size() > k){
            minHeap.poll();
        }

        return minHeap.peek();
    }
}
