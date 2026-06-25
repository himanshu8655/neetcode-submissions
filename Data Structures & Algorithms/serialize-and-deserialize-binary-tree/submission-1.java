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
        StringBuilder builder = new StringBuilder();
        dfs(root, builder);
        return builder.toString();
        
    }

    void dfs(TreeNode root, StringBuilder str){
        if(root == null){
            str.append("#,");
            return;
        }
        str.append(root.val);
        str.append(",");
        dfs(root.left, str);
        dfs(root.right, str);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strArray = data.split(",");
        return helper(strArray, new int[]{0});
    }

    public TreeNode helper(String[] array, int[] idx){
        if(idx[0]>=array.length)
            return null;
        if (array[idx[0]].equals("#")) {
            idx[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(array[idx[0]++]));
        root.left = helper(array, idx);
        root.right = helper(array, idx);
        return root;
    }
}
