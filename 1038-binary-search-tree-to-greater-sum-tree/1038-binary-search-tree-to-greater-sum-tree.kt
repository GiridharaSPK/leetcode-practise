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
        // iterative approach
        val st = Stack<TreeNode>()
        var sum = 0
        var node = root
        while(!st.isEmpty() || node!=null){
            while(node!=null){
                st.push(node)
                node = node.right
            }
            node = st.pop()
            sum += node.`val`
            node.`val` = sum

            node = node.left
        }
        return root
        // recursive apporach
        /*helper(root)
        return root*/
    }
    
    /*var sum = 0
    fun helper(root: TreeNode?){
        if(root == null){
            return
        }
        
        helper(root!!.right)
        sum += root!!.`val`
        root!!.`val` = sum
        helper(root!!.left)
    }*/
    
}