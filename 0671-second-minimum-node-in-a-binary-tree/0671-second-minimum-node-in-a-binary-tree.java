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
    public int findSecondMinimumValue(TreeNode root) {
        long[] min = new long[2];
        min[0] = root.val;
        min[1] = Long.MAX_VALUE;
        helper(root, min);
        return (min[1] == Long.MAX_VALUE) ? -1: (int) min[1];
    }
    
    private void helper(TreeNode root, long[] min){
        if(root == null) return;
        
        if(root.val > min[0] && root.val < min[1])
            min[1] = root.val;
        
        helper(root.left, min);
        helper(root.right, min);
    }
    
}