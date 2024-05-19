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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inorderMap = new HashMap();
        for(int i = 0; i < inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        return helper(preorder, inorderMap, 0, preorder.length-1, 0, inorder.length-1);
    }
    
    private TreeNode helper(int[] preorder, HashMap<Integer, Integer> inorderMap, 
                        int pres, int pree, int ins, int ine){
        if(pree >= preorder.length || pres > pree
           || ins > ine) return null;
        
        //current node
        int nodeval = preorder[pres];
        TreeNode node = new TreeNode(nodeval);
        
        //index of current node
        int index = inorderMap.get(node.val);         
        
        node.left = helper(preorder, inorderMap, pres+1, pres+index-ins, ins, index-1);
        node.right = helper(preorder, inorderMap, pres+index-ins+1, pree, index+1, ine);
        
        return node;
    }
    
}