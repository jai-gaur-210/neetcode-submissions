class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int l = 0; int j = m-1;
        while(l<n && j>=0){
            if(matrix[l][j] == target){
                return true;
            }
            else if(matrix[l][j] < target){
                l++;
            }
            else{
                j--;
            }
        }
        return false;
    }
}
