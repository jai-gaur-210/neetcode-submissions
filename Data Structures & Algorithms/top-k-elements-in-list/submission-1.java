class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> m = new HashMap<>();
        for(int i=0; i<n; i++){
            m.put(nums[i], m.getOrDefault(nums[i], 0)+ 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> b[0]-a[0]);
        for(int i : m.keySet()){
            pq.offer(new int[]{m.get(i), i});
        }
        int ans[] = new int[k];
        int idx = 0;
        while(k>0){
            ans[idx] = pq.poll()[1];
            idx++; k--;
        }
        return ans;
    }
}
