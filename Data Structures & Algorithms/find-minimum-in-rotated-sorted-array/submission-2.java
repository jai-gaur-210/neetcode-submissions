class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        while(l<r){
            int mid = (l+r)/2;
            if(nums[mid]>nums[r]){
                l = l+1;
            }
            else{
                r = r-1;
            }
        }
        return nums[l];
    }
}
