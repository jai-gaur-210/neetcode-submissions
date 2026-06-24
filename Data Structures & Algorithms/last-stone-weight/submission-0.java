class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i:stones){
            q.offer(i);
        }
        while(q.size()>1){
            int a = q.poll();
            int b = q.poll();
            if(a > b){
                q.offer(a - b);
            }
        }
        if(q.isEmpty()){
            return 0;
        }
        return q.poll();
    }
}