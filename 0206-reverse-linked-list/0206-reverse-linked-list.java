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
        // recursive approach
        if(head == null || head.next == null) return head;
    
        ListNode temp = head.next; //storing the last node of the reversed sublist
        ListNode reversedHead = reverseList(head.next); // returns reversed sublist head
        head.next = null;
        temp.next = head;        
        return reversedHead;
        
        // approach without using dummy node - swapping pointers
        // 3 pointer approach - starting from null, curr and next
        /*ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            // backup next node
            ListNode next = curr.next;
            // realign link
            curr.next = prev;
            // propogate
            prev = curr;
            curr = next;
        }
        return prev;*/
        // 3 pointer approach - starting from first node
        
        /*if(head == null || head.next == null) return head;
        // there are atleast 2 nodes
        ListNode f = head;
        ListNode s = head.next;
        ListNode t = head.next.next;
        
        f.next = null; // ** first node should be last node [imp to avoid cycle]
        while(s!=null){
            s.next = f;
            f = s;
            s = t;
            if(t!=null)
                t = t.next;
        }
        return f;*/
        
        // approach using a dummyNode - faster then 100%
        /*ListNode dummy = new ListNode(-1);
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
        
        return dummy.next;*/
    }
}