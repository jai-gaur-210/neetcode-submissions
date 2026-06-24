class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, ans, nums, new ArrayList<>());
        return ans;
    }

    public void backtrack(int idx, List<List<Integer>> ans, int []nums, List<Integer> path){
        ans.add(new ArrayList<>(path));
        
        for(int i=idx; i<nums.length; i++){
            if(i > idx && nums[i] == nums[i-1]) continue;
            path.add(nums[i]);
            backtrack(i+1, ans, nums, path);
            path.remove(path.size()-1);
        }
        
    }
}