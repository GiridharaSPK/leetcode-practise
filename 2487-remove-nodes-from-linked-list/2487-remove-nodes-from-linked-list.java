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
    public ListNode removeNodes(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode reversedHead = reverse(head);
        ListNode ptr = reversedHead;
        ListNode prev = null;
        int max = reversedHead.val;
        while(ptr!=null){
            if(max <= ptr.val){
                // update max
                max = ptr.val;
                prev = ptr;
            }else{
                // remove ptr node
                prev.next = ptr.next;
            }
            ptr = ptr.next;
        }
        return reverse(reversedHead);
    }
    
    private ListNode reverse(ListNode head){
        ListNode ptr = null;
        ListNode left = null;
        ListNode right = head;
        
        while(right!=null){
            ptr = right.next;
            right.next = left;
            left = right;
            right = ptr;
        }
        return left;
    }
    
}