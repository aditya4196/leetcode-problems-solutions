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

        ListNode rl1 = reverseList(l1);
        ListNode rl2 = reverseList(l2);

        ListNode output = new ListNode(-1);
        ListNode dummy = output;

        int carry=0;
        while(rl1!=null || rl2!=null){
            int sum = ((rl1 != null)?rl1.val:0) + ((rl2 != null)?rl2.val:0) + carry;

            if(sum > 9){
                sum %= 10;
                carry = 1;
            }
            else carry = 0;
            dummy.next = new ListNode(sum);
            dummy = dummy.next;

            rl1 = (rl1!=null)?rl1.next:rl1;
            rl2 = (rl2!=null)?rl2.next:rl2;
        }
        if(carry == 1){
            dummy.next = new ListNode(1);
        }
        dummy = dummy.next;

        return reverseList(output.next);
    
        
    }

    public ListNode reverseList(ListNode node){
        if(node == null || node.next == null) return node;
        ListNode curr = node, nextcurr = null, prev = null;

        while(curr!=null){
            nextcurr = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextcurr;
        }
        return prev;
    }
}