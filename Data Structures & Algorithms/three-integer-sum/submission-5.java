class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> s = new HashSet<>();
        for(int i=0; i<nums.length-2; i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int j=i+1; int k=nums.length-1;

            while(j<k){
                List<Integer> l = new ArrayList<>();
                if((nums[i] + nums[j] + nums[k]) == 0){
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[k]);
                    s.add(l);
                    j++;
                    k--;
                }
                else if((nums[i] + nums[j] + nums[k]) > 0){
                    k--;
                }
                else{
                    j++;
                }
            }
            
        }  
        return new ArrayList<List<Integer>>(s);
    }
}