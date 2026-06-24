class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> Double.compare(Distance(b), Distance(a)));
        
        for(int[] i: points){
            q.offer(i);
            if(q.size() > k){
                q.poll();
            }
        }
        int[][]ans = new int[k][2];
        int cnt = 0;
        for(int[] i : q){
            ans[cnt] = i;
            cnt++;
        }
        return ans;
    }

    public double Distance(int []a){
        double ans = (a[0]*a[0]) + (a[1]*a[1]);
        return ans;
    }
}