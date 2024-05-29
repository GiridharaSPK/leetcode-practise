/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(-1);
        ListNode l = head;
        ListNode r = head.next;
        ListNode temp = dummy;
        // attach every node from left to right to the next of dummy node
        
        while(l!=null && r!=null){
            temp = dummy.next;
            dummy.next = l;
            dummy.next.next = temp;
            
            l = r;
            r = r.next;
        }
        // last node
        temp = dummy.next;
        dummy.next = l;
        dummy.next.next = temp;
        
        return dummy.next;
    }
}