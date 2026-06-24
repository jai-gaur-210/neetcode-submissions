class MedianFinder {
    PriorityQueue<Integer> low;
    PriorityQueue<Integer> high;
    public MedianFinder() {
        low =  new PriorityQueue<>(Collections.reverseOrder());
        high =  new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        low.offer(num);
        high.offer(low.poll());
        if(high.size() > low.size()){
            low.offer(high.poll());
        }
    }
    
    public double findMedian() {
        if(low.size() == high.size()){
            return (double)(low.peek()+high.peek())/2;
        }
        return (double)low.peek();
    }
}