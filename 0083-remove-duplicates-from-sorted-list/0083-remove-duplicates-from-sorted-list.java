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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode curr = head;
        ListNode nextcurr = head.next;
        
        while(nextcurr != null){
            if(curr.val == nextcurr.val){
                curr.next = nextcurr.next;
                nextcurr = curr.next;
            }
            else{
                curr = curr.next;
                nextcurr = nextcurr.next;    
            }

        }
        
        return head;
        
    }
}


/*

1 -> 2 -> 3 -> 3

i.   
     


*/