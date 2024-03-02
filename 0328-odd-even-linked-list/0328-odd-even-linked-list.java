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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode oddstart = head;
        ListNode evenstart = head.next; 
        ListNode devenstart = evenstart;
        
        while(oddstart.next!=null && devenstart.next!=null){
            oddstart.next = devenstart.next;
            oddstart = oddstart.next;
            
            devenstart.next = oddstart.next;
            devenstart = devenstart.next;
        }
        
        oddstart.next = evenstart;
        return head;
        
    }
}