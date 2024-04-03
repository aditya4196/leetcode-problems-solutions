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
        
        ListNode fast = head, slow = head;
        
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            
            if(slow == fast){
                ListNode newslow = head;
                while(newslow != slow){
                    slow = slow.next;
                    newslow = newslow.next;
                }
                return slow;
            }
        }
        
        
        return null;
        
    }
}