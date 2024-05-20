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
    //height balanced : difference in left and right subtree heights is <= 1 for each node
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -2;
        
        // O(n^^2) approach - top down approach
        // test case - empty tree
        /*if(root == null) return true;
        
        if(Math.abs(height(root.left) - height(root.right)) < 2){
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;*/
    }
    
    private int helper(TreeNode node){ // returns height and isbalanced - returns height or -2
        if(node == null) return -1;
        
        int left = helper(node.left);
        int right = helper(node.right);
        if(left == -2 || right == -2) return -2;
        
        if(Math.abs(left - right) < 2) 
            return Math.max(left, right)+1;
        
        return -2;
    }
    
    // O(n) for each node
    private int height(TreeNode node){
        if(node == null) return -1;
        
        return Math.max(height(node.left), height(node.right)) + 1;
    }
    
}