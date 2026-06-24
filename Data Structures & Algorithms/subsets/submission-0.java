class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    public void helper(int idx, int []nums, List<Integer> path, List<List<Integer>> ans){
        if(idx == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[idx]);
        helper(idx+1, nums, path, ans);
        path.remove(path.size()-1);
        helper(idx+1, nums, path, ans);
    }
}