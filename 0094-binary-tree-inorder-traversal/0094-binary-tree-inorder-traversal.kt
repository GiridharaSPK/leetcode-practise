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
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val list = ArrayList<Int>()
        helper(root, list)
        return list
    }
    
    private fun helper(root: TreeNode?, list: ArrayList<Int>){
        if(root == null){
            return
        }
        helper(root!!.left, list)
        list.add(root.`val`)
        helper(root!!.right, list)
    }
}