class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] arr = new int[n + m];
        int cnt = 0;
        int l = 0, r = 0;

        while (l < n && r < m) {
            if (nums1[l] < nums2[r]) {
                arr[cnt++] = nums1[l++];
            } else {
                arr[cnt++] = nums2[r++];
            }
        }

        while (l < n) {
            arr[cnt++] = nums1[l++];
        }

        while (r < m) {
            arr[cnt++] = nums2[r++];
        }

        double res;
        int total = arr.length;

        if (total % 2 == 0) {
            int mid1 = (total / 2) - 1;
            int mid2 = mid1 + 1;
            res = (arr[mid1] + arr[mid2]) / 2.0;
        } else {
            int mid = total / 2;
            res = arr[mid];
        }

        return res;
    }
}