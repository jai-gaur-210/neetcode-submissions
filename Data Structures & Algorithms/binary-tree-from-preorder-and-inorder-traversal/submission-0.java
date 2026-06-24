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
    Map<Integer, Integer> map = new HashMap<>();
    int cnt = 0;
    public TreeNode built(int []preorder, int left, int right){
        if(left > right) return null;
        int rootVal = preorder[cnt];
        cnt++;
        TreeNode root = new TreeNode(rootVal);
        root.left = built(preorder, left, map.get(rootVal) -1);
        root.right = built(preorder, map.get(rootVal) +1, right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        int l = 0;
        int r = inorder.length-1;
        return built(preorder, l, r);
    }
}
