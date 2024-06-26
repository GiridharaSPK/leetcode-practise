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
        // morris traversal : O(n) time and constant space
        // alter the links of left node's right ptr to point to head
        var node = root
        var temp = root
        val list = ArrayList<Int>()
        
        // at every node from root, check if there is a left node - alter links
        // if no left node add to answer and move right
        while(node!=null){ 
            var left = node.left
            if(left!=null){ // alter right most child/grandchild of the left 
                while(left!!.right!=null){
                    left = left.right
                }
                left!!.right = node
                temp = node
                node = node.left // assigning it to current `node`
                temp.left = null
            }else{ // no left node
                list.add(node.`val`) // add to answer list
                node = node.right // move right 
            }
        }
        
        return list
        
        // recursion : O(n) space and O(n) time
        /*val list = ArrayList<Int>()
        helper(root, list)
        return list*/
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