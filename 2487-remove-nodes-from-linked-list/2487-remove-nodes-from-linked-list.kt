/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
 
    private fun reverse(head: ListNode) : ListNode{
        val dummy = ListNode(0)
        var right = head
        var left : ListNode? = null
        var ptr : ListNode? = null
        while(right!=null){
            ptr = right.next
            right.next = left
            left = right
            right = ptr
        }
        
        return left!!
    }
    
    fun removeNodes(head: ListNode?): ListNode? {
        head ?: return null
        // better approach without extra space
        // reverse the list 
        // traverse and delete smaller nodes
        /*val newHead = reverse(head)
        var ptr : ListNode? = newHead
        var max = newHead.`val`
        var prev : ListNode? = null
        while(ptr!=null){
            if(max <= ptr.`val`){
                max = ptr.`val`
                prev = ptr
                ptr = ptr.next
            }else {
                prev?.next = ptr.next
                ptr = ptr.next
            }

        }
        return reverse(newHead)*/
    
        
        // O(n) using stack to traverse in reverse 
        val stack = Stack<ListNode>()

        var ptr = head
        while(ptr!=null){
            while(!stack.isEmpty() && stack.peek().`val` < ptr.`val`){
                stack.pop()
            }
            stack.add(ptr)
            ptr = ptr.next
        }
        
        var prev : ListNode? = null
        var curr : ListNode? = null
        while(!stack.isEmpty()){
            curr = stack.pop()
            curr.next = prev
            prev = curr
        }
        
        return prev
    }
}