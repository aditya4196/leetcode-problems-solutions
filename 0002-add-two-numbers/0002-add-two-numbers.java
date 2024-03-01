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
        
        ListNode result = new ListNode();
        ListNode dummy = result;
        
        int carry = 0;
        
        while(l1!=null || l2!=null){
            int sum = ((l1 == null)?0:l1.val) + ((l2==null)?0:l2.val) + carry;
            
            if(sum > 9) carry = 1;
            else carry = 0;
            sum%=10;
            
            
            dummy.next = new ListNode(sum);
            dummy = dummy.next;
            l1 = (l1!=null)?l1.next:l1;
            l2 = (l2!=null)?l2.next:l2;
        }
        
        if(carry == 1) dummy.next = new ListNode(1);
        return result.next;
        
        
        
    }
}