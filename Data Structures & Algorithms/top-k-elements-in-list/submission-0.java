class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> m = new HashMap<>();
        for(int i=0; i<n; i++){
            m.put(nums[i], m.getOrDefault(nums[i], 0)+ 1);
        }
        int idx = 0;
        int ans[] = new int[k];
        for (Map.Entry<Integer, Integer> entry :
                m.entrySet()
                    .stream()
                    .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                    .collect(Collectors.toList())) {

            ans[idx++] = entry.getKey();

            if (idx == k) {
                break;
            }
        }

        return ans;
    }
}
