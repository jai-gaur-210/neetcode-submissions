class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        Set<Integer> numset = new HashSet<>();
        for(int n : nums){
            numset.add(n);
        }
        for(int n: nums){
            int length = 0;
            if(!numset.contains(n-1)){
                while(numset.contains(n + length)){
                    length++;
                }
                longest = Math.max(longest,length);
            }
        }
        return longest;  
    }
}
