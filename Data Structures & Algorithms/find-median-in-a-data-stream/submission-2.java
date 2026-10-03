class MedianFinder {
    PriorityQueue<Double> left = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Double> right = new PriorityQueue<>();

    public MedianFinder() {
    }
    
    public void addNum(int num) {
        left.offer((double) num);
        right.offer(left.poll());
        if(right.size()>left.size()){
            left.offer(right.poll());
        }
    }
    
    public double findMedian() {
        if(left.size()>right.size()){
            return left.peek();
        }
        else{
            return (left.peek()+right.peek())/2;
        }
    }
}
