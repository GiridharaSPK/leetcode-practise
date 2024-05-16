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
        if(root == null && subRoot == null) return true;
        
        if(root == null && subRoot != null || root !=null && subRoot == null) return false;
        
        // cant check by comparing if isSubTrees are same 
        // when roots are equal subtrees also have to be equal
       /* if(root.val == subRoot.val){
            boolean subTreeTrue = (isSubtree(root.left, subRoot.left) 
                && isSubtree(root.right, subRoot.right));
            if(subTreeTrue) return true;
        }*/
        
        if(root.val == subRoot.val){
            if(isEqual(root, subRoot)) return true;
        }
        
        if(isSubtree(root.left, subRoot)) return true;
        if(isSubtree(root.right, subRoot)) return true;
        
        return false;
    }
    
    private boolean isEqual(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return true;
        if((root1 == null && root2!= null) || (root2 == null && root1!= null)) return false;
        if(root1.val == root2.val){
           return isEqual(root1.left, root2.left) && isEqual(root1.right, root2.right);
        }
        return false;
    }
}