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
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
       // Iterative approach : O(n) time + O(n) space (stack)
        // needs a class variable to maintain curr sum
        /*Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while(node!=null || !stack.isEmpty()){
            // push all right nodes to stack
            // right
            while(node!=null){
                stack.push(node);
                node = node.right;
            }
            // current 
            TreeNode temp = stack.pop();
            sum += temp.val;
            temp.val = sum;
            
            // go left
            node = temp.left;
        }
        return root;*/
        
        // recursive apporach : O(n) time + O(n) space (recursive stack)
        // needs a class variable for sum
        helper(root);
        return root;
    }
    
    private void helper(TreeNode root){
        if(root == null)
            return;
        
        helper(root.right);
        sum += root.val;
        root.val = sum;
        helper(root.left);
    }
    
}