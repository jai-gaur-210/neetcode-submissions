class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[] = new int[26];
        for(int i=0; i<tasks.length; i++){
            freq[tasks[i] - 'A']++;
        }
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : freq){
            if(i>0){
                q.offer(i);
            }
        }
        int time = 0;
        while(!q.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int cnt = 0;
            for(int i=0; i<n+1 && !q.isEmpty(); i++){ 
                int a = q.poll();
                time++;
                cnt++;
                if(a > 1){
                    temp.add(a-1);
                }
            }
            for(int i:temp){
                q.offer(i);
            }
            if(q.isEmpty()) break;
            for(int i=0; i<(n+1)-cnt; i++){
                time++;
            }
        }
        return time;
    }
}