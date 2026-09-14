/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int ans = Integer.MIN_VALUE;
    public int help(TreeNode root){
        if(root==null) return 0;
        int left = help(root.left);
        int right = help(root.right);
        int sum = left+right+root.val;
        int max = Math.max(root.val, Math.max(root.val+left, root.val+right));
        ans = Math.max(ans, Math.max(max, sum));
        return max;
    }
    public int maxPathSum(TreeNode root) {
        help(root);
        return ans;
    }
}
