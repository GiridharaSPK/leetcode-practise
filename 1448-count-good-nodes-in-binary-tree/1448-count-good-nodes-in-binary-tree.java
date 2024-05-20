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
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        // dfs to count nodes having bigger val than current node
        return helper(root, root.val);
    }
    
    private int helper(TreeNode root, int max){
        // base case
        int ans = 0; 
        if(root == null) return ans;
        
        // preorder traversal
        if(root.val >= max){
            ans = 1;
        }
        
        if(root.left!=null){
            ans+=helper(root.left, Math.max(max, root.left.val));
        }
        if(root.right!=null){
            ans+=helper(root.right, Math.max(max, root.right.val));
        }
        return ans;
    }
}