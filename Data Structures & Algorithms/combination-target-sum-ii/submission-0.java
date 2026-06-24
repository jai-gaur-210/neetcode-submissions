class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0, candidates, result, new ArrayList<>(), target);
        return result;
    }

    public void helper(int idx, int[] candidates, List<List<Integer>> result, List<Integer> path, int target){
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i=idx; i<candidates.length; i++){
            if(i > idx && candidates[i] == candidates[i-1]) continue;
            if(candidates[i] > target) return;
            path.add(candidates[i]);
            helper(i+1, candidates, result, path, target - candidates[i]);
            path.remove(path.size() - 1);
        }
    }
}