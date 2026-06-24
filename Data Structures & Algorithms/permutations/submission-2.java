class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean [] used = new boolean[nums.length];
        backtrack(ans, used, nums, new ArrayList<>());
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, boolean [] used, int[] nums, List<Integer> path){
        if(path.size() == nums.length){
            ans.add(new ArrayList<>(path));
        }
        for(int i=0; i<nums.length; i++){
            if(used[i] == true) continue;
            path.add(nums[i]);
            used[i] = true;
            backtrack(ans, used, nums, path);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
