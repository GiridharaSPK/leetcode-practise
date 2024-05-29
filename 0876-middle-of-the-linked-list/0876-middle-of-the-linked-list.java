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
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) return head; //dont forget
        
        ListNode fast = head;
        ListNode slow = head;
        // adding fast.next to while condition is imp
        // from test cases - fast ptr have be at last if odd nodes, null if even
        while(fast!=null && fast.next!=null){ 
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}