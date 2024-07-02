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
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        val ar = IntArray(1)
        // kotlin syntax issue?
        
        // approach 1 - working
        // val temp = helper(root, ar)
        // return Math.max(ar[0], temp)
        
        // approach 2 - working
        return Math.max(helper(root, ar), ar[0])
        
        // approach 3 - doesn't  work // because order matters
        // return Math.max(ar[0], helper(root, ar))
    }
    
    fun helper(root : TreeNode?, ar: IntArray): Int {
        if(root == null) return -1;

        val left = 1 + helper(root.left, ar)
        val right = 1 + helper(root.right, ar)
        
        val currHeight = Math.max(left, right)
        val currDiameter = left + right
        ar[0] = Math.max(ar[0], Math.max(currDiameter, currHeight))
        return currHeight
    }
}