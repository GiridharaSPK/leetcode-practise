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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return null; // not new ListNode(0);
        
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        
        // both lists are non empty
        ListNode p1 = list1;
        ListNode p2 = list2;
        
        // create dummy node
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        
        // attach only single node from one of the lists at once
        // ptrs can traverse upto last node
        while(p1!= null && p2!= null){ 
            if(p1.val < p2.val){
                head.next = p1;
                p1 = p1.next;
            }else{
                head.next = p2;
                p2 = p2.next;
            }
            head = head.next;
        }
        
        if(p1 != null){
            head.next = p1;
        }
        
        if(p2 != null){
            head.next = p2;
        }
        
        return dummy.next;   
    }
}