class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> l = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        help(nums, target, 0, l, ans);
        return ans;
    }

    public void help(int[] nums, int t, int idx, List<Integer> l, List<List<Integer>> ans){
        if(t==0){
            ans.add(new ArrayList<>(l));
            return;
        }
        if(idx==nums.length || t<0){
            return;
        }
        // take
        l.add(nums[idx]);
        help(nums, t-nums[idx], idx, l, ans);
        // not take
        l.remove(l.size()-1);
        help(nums, t, idx+1, l, ans);
    }
}
