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
        
        // recursive approach : O(n) space and O(n) time
        helper(root)
        return root
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