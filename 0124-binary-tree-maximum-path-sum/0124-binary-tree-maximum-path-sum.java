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
    public int maxPathSum(TreeNode root) {
        // aditya verma appraoch - DP on Trees
        int max[] = {root.val}; // atleast 1 node have to part of the answer 
        // cant initialise max with 0 - wont work if all the nodes are negative
        int ans = solve(root, max);
        return Math.max(max[0], ans);
    }
    
    private int solve(TreeNode root, int[] max){
        if(root == null) return 0;
        
        int left = solve(root.left, max);
        int right = solve(root.right, max);
        
        // if the node contributes to path (only one child can contribute)
        int temp = Math.max(root.val + Math.max(left, right), root.val);
        
        //if the node itself is the path - update globally
        max[0] = Math.max(max[0], Math.max(temp, left + right + root.val));
        
        return temp;
    }
    
    
}