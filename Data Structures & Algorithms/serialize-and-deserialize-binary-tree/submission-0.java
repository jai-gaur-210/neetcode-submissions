/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;

        StringBuilder ans = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode temp = q.remove();
            if (temp != null) {
                ans.append(temp.val).append(',');
                q.add(temp.left);
                q.add(temp.right);
            } else {
                ans.append("null,");
            }
        }
        ans.setLength(ans.length() - 1);
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null) return null;
        // 1,2,3,null,null,4,5,null,null,null,null
        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int k = 1;
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(!nodes[k].equals("null")){
                TreeNode Child = new TreeNode(Integer.parseInt(nodes[k]));
                temp.left = Child;
                q.add(Child);
            }
            k++;
            if(!nodes[k].equals("null")){
                TreeNode Child = new TreeNode(Integer.parseInt(nodes[k]));
                temp.right = Child;
                q.add(Child);
            }
            k++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));