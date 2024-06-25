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
    fun bstToGst(root: TreeNode?): TreeNode? {
        helper(root)
        return root
    }
    
    var sum = 0
    fun helper(root: TreeNode?){
        if(root == null){
            return
        }
        
        helper(root!!.right)
        sum += root!!.`val`
        root!!.`val` = sum
        helper(root!!.left)
    }
    
}