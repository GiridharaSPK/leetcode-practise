/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = head;
        if (prev == null)
            return head;
        ListNode curr = head.next;
        if (curr == null)
            return head;

        while (curr != null) {
            while (curr != null && curr.val == prev.val) {
                curr = curr.next;
            }
            prev.next = curr;

            if (curr != null) {
                prev = curr;
                curr = curr.next;
            }
        }

        return head;
    }
}
