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
    //preorder root - left - right
    //inOrder left - root - right
    int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inOrderMap = new HashMap<>();
        int n = inorder.length;
        for(int i = 0; i<n; i++){
            inOrderMap.put(inorder[i], i);
        }

        return helper(preorder, 0, n - 1, inOrderMap);
    }

    public TreeNode helper(int[] preorder, int l, int r, HashMap<Integer, Integer> inOrderMap){
        if(l>r)
            return null;

        TreeNode root = new TreeNode(preorder[idx++]);
        root.left = helper(preorder, l, inOrderMap.get(root.val) - 1, inOrderMap);
        root.right = helper(preorder, inOrderMap.get(root.val)+1, r,inOrderMap);
        return root;
    }
}
