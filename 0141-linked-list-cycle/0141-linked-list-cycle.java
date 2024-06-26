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
    public boolean hasCycle(ListNode head) {
        // if(head == null) return false;
        
        ListNode fast = head;
        ListNode slow = head;
        
        // while(slow.next!=null && fast.next!=null && fast.next.next!=null){
        // checking for curr pointers instead of cur.next help avoid null head base case
        while(slow!=null && fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            
            if(slow == fast) return true;
        }
        return false;
    }
}