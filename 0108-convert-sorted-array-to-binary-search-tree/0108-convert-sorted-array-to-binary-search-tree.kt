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
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return helper(nums, 0, nums.size-1)
    }
    
    private fun helper(nums : IntArray, start : Int, end: Int) : TreeNode?{
        if(end < start) 
            return null
        
        val mid = start + (end - start)/2
        val node = TreeNode(nums[mid])
        node.left = helper(nums, start, mid-1)
        node.right = helper(nums, mid+1, end)
        return node
    }
}