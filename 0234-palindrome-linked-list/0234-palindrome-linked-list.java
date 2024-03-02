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
    public boolean isPalindrome(ListNode head) {
        
        ListNode fast = head, slow = head;
        
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        if(fast!=null) slow = slow.next;
        ListNode revhead = reverse(slow);
        
        while(revhead!=null){
            if(revhead.val != head.val) return false;
            revhead = revhead.next;
            head = head.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode curr){
        if(curr == null || curr.next == null) return curr;
        ListNode newhead = reverse(curr.next);
        curr.next.next = curr;
        curr.next = null;
        return newhead;
    }
}

