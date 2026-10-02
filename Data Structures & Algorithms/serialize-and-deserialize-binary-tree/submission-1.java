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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp == null){
                sb.append("null,");
                continue;
            }
            sb.append(temp.val);
            sb.append(",");
            q.offer(temp.left);
            q.offer(temp.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // 1,2,3,n,n,4,5,n,n
        if(data == "") return null;
        String str[] = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int k = 1;
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(!str[k].equals("null")){
                node.left = new TreeNode(Integer.parseInt(str[k]));
                q.offer(node.left);
            }
            k++;
            if(!str[k].equals("null")){
                node.right = new TreeNode(Integer.parseInt(str[k]));
                q.offer(node.right);
            }
            k++;
        }

        return root;
    }
}
