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
        var sum = 0

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
 
        // iterative approach : O(n) space and O(n) time
        /*val st = Stack<TreeNode>()
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
        return root*/
        
        // recursive apporach : O(n) space and O(n) time
        /*helper(root)
        return root*/
    }
    
    /*var sum = 0
    private fun helper(root: TreeNode?){
        if(root == null){
            return
        }
        
        helper(root!!.right)
        sum += root!!.`val`
        root!!.`val` = sum
        helper(root!!.left)
    }*/
    
}