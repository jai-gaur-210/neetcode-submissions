class MedianFinder {
    List<Double> q = new ArrayList<>();
    
    public MedianFinder() {
    }
    
    public void addNum(int num) {
        q.add((double)num);
        Collections.sort(q);
    }
    
    public double findMedian() {
        int n = q.size();
        if(n%2==0){
            int mid = n/2;
            return (q.get(mid-1)+q.get(mid))/2;
        }
        else{
            int mid = n/2;
            return q.get(mid);
        }
    }
}
