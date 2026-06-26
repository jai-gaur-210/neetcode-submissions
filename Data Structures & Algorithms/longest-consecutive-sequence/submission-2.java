class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return nums.length;
        }
        Set<Integer> s = new HashSet<>();
        for(int i : nums){
            s.add(i);
        }
        int ans = 1;
        for(int i : nums){
            if(!s.contains(i-1)){
                int k = 1;
                int v = i;
                while(s.contains(v+1)){
                    v++;
                    k++;
                    ans = Math.max(ans, k);
                }
            }
        }
        return ans;
    }
}
