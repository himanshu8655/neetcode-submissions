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
    int idx = 1;
    int result = 0;
    public int kthSmallest(TreeNode root, int k) {
        preOrder(root, k);
        return result;
    }

    public void preOrder(TreeNode root, int k){
        if(root == null)
            return;
        preOrder(root.left, k);
        if(idx == k){ 
            result = root.val;
        }
        idx++;
        preOrder(root.right, k);
    }
}
