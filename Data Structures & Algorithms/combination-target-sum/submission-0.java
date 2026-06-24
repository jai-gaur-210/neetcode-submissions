class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(0, candidates, result, new ArrayList<>(), target);
        return result;
    }

    public void helper(int idx, int[] candidates, List<List<Integer>> result, List<Integer> path, int target){
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target < 0 || idx == candidates.length){
            return;
        }
        path.add(candidates[idx]);
        helper(idx, candidates, result, path, target - candidates[idx]);
        path.remove(path.size() - 1);
        helper(idx+1, candidates, result, path, target);
    }
}