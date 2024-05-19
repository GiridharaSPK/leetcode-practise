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
    public int diameterOfBinaryTree(TreeNode root) { // dp on trees - aditya verma std approach
        int[] res = {Integer.MIN_VALUE};
        int temp = helper(root, res);
        return Math.max(temp, res[0]);
    }
    
    private int helper(TreeNode node, int[] res){ //returns height of the current node
        if(node == null) return -1;
        
        int left = 1+ helper(node.left, res); // height of left child + current-left edge
        int right = 1+ helper(node.right, res);
        
        int temp = Math.max(left, right);
        res[0] = Math.max(res[0], Math.max(left+right, temp));
        
        return temp;
    }
}