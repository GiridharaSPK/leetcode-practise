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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null) return root;
        if(root.left!=null && removeLeafNodes(root.left, target) == null){
            root.left = null;
        }
        if(root.right!=null && removeLeafNodes(root.right, target) == null){
            root.right = null;
        }
        if(root.left == null && root.right == null && root.val == target){
            return null;
        }
        
        return root;
    }
}