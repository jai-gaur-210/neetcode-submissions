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
    int cnt = 0;
    int result = -1;
    public void traverse(TreeNode root, int k){
        if (root == null || result != -1) return;
        traverse(root.left, k);
        cnt++;
        if(cnt == k){
            result = root.val;
            return;
        }
        traverse(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return result;
    }
}
