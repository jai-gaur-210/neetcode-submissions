class Solution {
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    LinkedList<String> ans = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> l : tickets){
            String from = l.get(0);
            String to = l.get(1);
            map.computeIfAbsent(from, k -> new PriorityQueue<>()).add(to);
        }
        dfs("JFK");
        return ans;
    }

    public void dfs(String airport){
        PriorityQueue<String> nei = map.get(airport);
        while(nei != null && !nei.isEmpty()){
            dfs(nei.poll());
        }
        ans.addFirst(airport);
    }
}