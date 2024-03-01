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
        ListNode fast = head;
        ListNode slow = head;
        
        if(head == null || head.next == null) return true;
        
        List<Integer> vals = new ArrayList();
        
        while(fast!=null && fast.next!=null){
            vals.add(slow.val);
            fast = fast.next.next;
            slow = slow.next;
        }
        
        int ptr = vals.size()-1;

        if(fast!=null) slow = slow.next;
        
        while(slow!=null){
            
            if(vals.get(ptr--) != slow.val) return false;
            slow = slow.next;
        }
        
        return true;
        
        
        
        
    }
}