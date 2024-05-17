/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p == q) return p;
        if(root==null || root == p || root == q) return root;
        if(p.val < root.val && root.val < q.val 
           || p.val > root.val && root.val > q.val){
            return root;
        }
        
        if(p.val > root.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        
        return lowestCommonAncestor(root.left, p, q);
    }
}