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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode newl1 = reverse(l1);
        ListNode newl2 = reverse(l2);
        
        ListNode result = new ListNode();
        ListNode dummy = result;
        int carry = 0;
        
        while(newl1!=null || newl2!=null){
            int val1 = (newl1 == null)?0:newl1.val;
            int val2 = (newl2 == null)?0:newl2.val;
            int sum = val1 + val2 + carry;
            
            if(sum > 9) carry = 1;
            else carry = 0;
            sum%=10;
            
            dummy.next = new ListNode(sum);
            dummy = dummy.next;
            newl1 = (newl1 == null)?newl1:newl1.next;
            newl2 = (newl2 == null)?newl2:newl2.next;
        }
        
        if(carry == 1) dummy.next = new ListNode(1);
        
        return reverse(result.next);
        
    }
    
    public ListNode reverse(ListNode curr){
        ListNode nextcurr = null, start = null;
        
        while(curr!=null){
            nextcurr = curr.next;
            curr.next = start;
            start = curr;
            curr = nextcurr;
        }
        return start;
    }
}