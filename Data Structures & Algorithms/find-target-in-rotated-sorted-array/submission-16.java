class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length-1;
        int l=0, r=n;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]==target) return mid;
            else if(nums[l]<=nums[mid]){
                if(target>=nums[l] && target<nums[mid]){
                    r=mid-1;
                }
                else{
                    l=mid+1;
                }
            }
            else { // Right half is sorted
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1; // Search right
                } else {
                    r = mid - 1; // Search left
                }
            }
        }
        return -1;
    }
}
