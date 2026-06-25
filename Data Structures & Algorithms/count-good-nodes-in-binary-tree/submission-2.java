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
    int result = 0;
    public int goodNodes(TreeNode root) {
        if(root == null)
            return 0;
        helper(root, root.val);
        return result;
    }

    public void helper(TreeNode root, int val){
        if(root == null){
             result++;
             return;
        }
           

        else if(root.val<val)
            return;
        
        
            helper(root.left, val);
            helper(root.right, val);
         
    }
}
