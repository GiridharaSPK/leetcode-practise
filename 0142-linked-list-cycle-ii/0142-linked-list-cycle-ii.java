/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode third = head;
        
        while(slow!=null && fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                // loop detected
                break;
            }
        }
        
        if(slow == null || fast == null || fast.next == null)
            return null;
        
        // there is a loop
        // MATH : distance from slow to start of cycle is 
        // equal to dist from head to start of cycle
        while(third!=slow){
            third = third.next;
            slow = slow.next;
        }
        return slow;
        
        // MATH 
        // L1 distance between head and start (of cycle)
        // L2 distance between start and collision in the direction of traversal
        // C - length of cycle
        // x number of extra loops rotated by fast than slow, before collision
        // distance traversed by slow = L1 + L2
        // distance traversed by fast = L1 + L2 + x * C 
        // dist(fast) = 2 * dist(slow);
        // L1 = x * C - L2; 
        // so by the time head moves to start, slow touches start

    }
}