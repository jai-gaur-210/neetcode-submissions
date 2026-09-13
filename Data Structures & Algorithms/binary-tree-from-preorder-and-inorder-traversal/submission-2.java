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
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return build(preorder, 0, inorder.length-1);
    }

    public TreeNode build(int[] preorder, int l, int r){
        if(l>r) return null;
        int value = preorder[cnt++];
        int mid = map.get(value);
        TreeNode root = new TreeNode(value);
        root.left = build(preorder, l, mid-1);
        root.right = build(preorder, mid+1, r);
        return root;
    }
}
