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
    public ListNode partition(ListNode head, int x) {
        
        if(head == null || head.next == null) return head;
        
        ListNode left = new ListNode();
        ListNode right = new ListNode();
        ListNode leftcurr = left, rightcurr = right;
        
        ListNode curr = head;
        
        while(curr != null){
            if(curr.val < x){
                leftcurr.next = new ListNode(curr.val);
                leftcurr = leftcurr.next;
            }
            else{
                rightcurr.next = new ListNode(curr.val);
                rightcurr = rightcurr.next;
            }
            curr = curr.next;
        }
        
        leftcurr.next = right.next;
        return left.next;
        
        
        
    }
}


/*

1 -> 4 -> 3 -> 2 -> 5 -> 2
                       i  

s -> 1 -> 2 -> 2
g -> 4 -> 3 -> 5


*/