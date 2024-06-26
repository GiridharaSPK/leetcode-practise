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
        // iterative apporach with stack
        val stack = Stack<TreeNode>()
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
        return root
        
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