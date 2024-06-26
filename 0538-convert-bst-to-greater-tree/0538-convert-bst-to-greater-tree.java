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
    public TreeNode convertBST(TreeNode root) {
        // Morris Traversal Approach : O(n) time + constant space
        
        // have to make new links to avoid using stack to trace back
        // as we have to move from greater elements to smaller elements
        // we have to update right pointers with parent element temporarily
        // create a new link between left most child of current node and parent node
        // all the temp ptrs have to be reversed/removed after finishing the current node sum
        // [reverse of Morris traversal of inorder]
        TreeNode node = root;
        int greaterSum = 0;
        while(node!=null){
            if(node.right!=null){
                TreeNode r = node.right;
                while(r.left!=null && r.left!= node){
                    r = r.left;
                }
                // right
                if(r.left == null){ // first time - create link
                    r.left = node;
                    node = node.right;
                }else{ // remove old link
                    r.left = null;
                    // update current node
                    greaterSum += node.val;
                    node.val = greaterSum;
                    // go left
                    node = node.left;
                }
            }else{
                greaterSum += node.val;
                node.val = greaterSum;
                node = node.left;
            }
        }
        
        return root;
        
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
        /*helper(root);
        return root;*/
    }
    
    // reverse of inoder traversal
    private void helper(TreeNode root){
        if(root == null)
            return;
        // right
        helper(root.right);
        // current node: add sum and update current node
        sum += root.val;
        root.val = sum;
        // go left
        helper(root.left);
    }
    
}