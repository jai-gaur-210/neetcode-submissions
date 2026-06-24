class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // -4 -1 -1 0 1 2
        // List<List<Integer>> list = new ArrayList<>();
        Set<List<Integer>> list = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int l= i+1; int r=nums.length-1;
            while(l<r){
                if(nums[i] + nums[l] + nums[r] == 0){
                    list.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
                    l++;r--;
                }
                else if(nums[i] + nums[l] + nums[r] > 0){
                    r--;
                }
                else{
                    l++;
                }
            }
        }
        return new ArrayList<List<Integer>>(list);
    }
}
