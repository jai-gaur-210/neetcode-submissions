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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> st = new LinkedList<>();
        if(root!=null) st.offer(root);
        while(!st.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int k = st.size();
            for(int i=0; i<k; i++){
                TreeNode curr = st.poll();
                list.add(curr.val);
                if(curr.left!=null) st.offer(curr.left);
                if(curr.right!=null) st.offer(curr.right);
            }
            ans.add(list);
        }
        return ans;
    }
}
