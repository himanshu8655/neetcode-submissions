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
    public int diameterOfBinaryTree(TreeNode root) {
        int left = dfs(root.left);
        int right = dfs(root.right);
        return left + right;
    }

    public int dfs(TreeNode root){
        if(root == null)
            return 0;
        
        return 1 + Math.max(dfs(root.left), dfs(root.right));
    }
}
