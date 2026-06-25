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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null)
            return true;
        
        if(root == null)
            return false;
        
        if(subRoot == null)
            return true;

        StringBuilder str1 = new StringBuilder();
        serialize(root, str1);
        StringBuilder str2 = new StringBuilder();
        serialize(subRoot, str2);

        return str1.toString().contains(str2.toString());
    }

    public void serialize(TreeNode root, StringBuilder str){
        if(root == null){
            str.append("#,");
            return;
        }
        
        str.append(root.val + ",");
        serialize(root.left, str);
        serialize(root.right, str);
    }
}
