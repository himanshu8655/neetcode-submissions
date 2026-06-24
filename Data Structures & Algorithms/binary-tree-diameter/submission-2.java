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
        
        int left = 1 + dfs(root.left);
        int right = 1 + dfs(root.right);
        return Math.max(left, right);
    }
}
