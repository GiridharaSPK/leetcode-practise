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
    fun balanceBST(root: TreeNode?): TreeNode? {
        // approach 1:
        // build a sorted list and build balanced bst from it recursively
        // O(n) time - (O(n) inorder traversal + O(logn) bst from array)
        // and O(n) space 
        // (recursive stack inroder traversal O(n) 
        // + recursive stack O(logn)+ arraylist O(n))
        val list = ArrayList<Int>()
        inorder(root, list)
        return buildBSTFromArray(list, 0, list.size-1)
    }
    
    private fun inorder(root: TreeNode?, list: ArrayList<Int>){
        if(root == null){
            return
        }
        inorder(root.left, list)
        list.add(root.`val`)
        inorder(root.right, list)
    }
    
    private fun buildBSTFromArray(list: ArrayList<Int>, start: Int, end: Int) : TreeNode?{ 
        if(end < start) return null
        val mid = start + (end - start)/2
        val node = TreeNode(list.get(mid))
        node.left = buildBSTFromArray(list, start, mid-1)
        node.right = buildBSTFromArray(list, mid+1, end)
        return node
    }
    
    private fun height(root : TreeNode?) : Int{
        if(root == null) return 0
        return 1 + Math.max(height(root.left), height(root.right))
    }
    
}