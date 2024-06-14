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
    fun removeNodes(head: ListNode?): ListNode? {
        head ?: return null
        val stack = Stack<Int>()

        var ptr = head
        while(ptr!=null){
            stack.add(ptr.`val`)
            ptr = ptr.next
        }
        
        var max = stack.peek()
        var prev : ListNode? = null
        var curr : ListNode? = null
        while(!stack.isEmpty()){
            val temp = stack.pop()
            if(max <= temp){
                max = temp
                curr = ListNode(temp)
                curr.next = prev
                prev = curr
            }
        }
        
        return prev
    }
}