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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length == 0) return null;
        int mid = 0;
        while (inorder[mid] != preorder[cnt]) {
            mid++;
        }
        TreeNode root = new TreeNode(preorder[cnt++]);
        root.left = buildTree(preorder, Arrays.copyOfRange(inorder, 0, mid));
        root.right = buildTree(preorder, Arrays.copyOfRange(inorder, mid+1, inorder.length));
        return root;
    }
}
