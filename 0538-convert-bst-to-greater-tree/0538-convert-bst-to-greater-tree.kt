/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    var sum = 0

    fun convertBST(root: TreeNode?): TreeNode? {
        // Approach with Morris Traversal : constant space and O(n) time
        // (no class variable usage)
        // update links to avoid stack usage
        // update links of right childs to parent to just keep on adding and moving 
        // [opposite of inorder traversal example]
        // but here we have to return the same tree 
        // so we have to remove temp links without removing any original links
        var node = root
        var greaterSum = 0
        while(node!=null){
            if(node.right!=null){
                // alter links
                // of its left most child to current node
                var r = node.right
                while(r.left!=null && r.left!= node){
                    r = r.left
                }
                // if here for the first time
                if(r.left == null){ 
                    // attaching to curr node - temporarily
                    r.left = node 
                    // move further right for next node   
                    node = node.right                  
                }else{ // already connected to parent node
                    // visiting second time i.e after adding the sum of the right
                    r.left = null // remove temp link
                    greaterSum += node.`val` // add greaterSum to current node
                    node.`val` = greaterSum // assign current greaterSum to current node
                    // move left (already added right of current node)
                    node = node.left
                }
            }else{ // no right node 
                greaterSum += node.`val`
                node.`val` = greaterSum
                node = node.left
            }
        }
        
        return root
        
        // iterative apporach with stack : O(n) space and O(n) time
        /*val stack = Stack<TreeNode>()
        var node = root
        while(node!=null || !stack.isEmpty()){
            // check right and add to stack
            while(node!=null){
                stack.push(node)
                node = node.right
            }
            
            // current (top of stack)
            val temp = stack.pop()
            sum += temp.`val`
            temp.`val` = sum
            
            // go left from current top of stack
            // (if current has left, go left, else pop from stack again)
            node = temp.left
        }
        return root*/
        
        // recursive approach : O(n) space and O(n) time
        /*helper(root)
        return root*/
    }
    
    private fun helper(root : TreeNode?){
        if(root == null)
            return
        // right
        helper(root.right)
        // add to current val
        sum += root.`val`
        root.`val` = sum
        // left
        helper(root.left)
    }
    
}