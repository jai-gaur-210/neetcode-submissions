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
    public void dfs(TreeNode root){
        if(root==null) return;
        dfs(root.left);
        cnt--;
        if(cnt == 0){
            ans = root.val;
        }
        dfs(root.right);
    }

    int ans=0, cnt=0;
    public int kthSmallest(TreeNode root, int k) {
        cnt=k;
        dfs(root);
        return ans;
    }

}
