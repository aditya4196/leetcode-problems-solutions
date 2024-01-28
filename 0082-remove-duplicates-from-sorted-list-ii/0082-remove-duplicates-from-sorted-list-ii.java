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
        
        ListNode result = new ListNode();
        result.next = head;
        ListNode curr = result;
        ListNode nextcurr = head;
        
        while(nextcurr != null){
            if(nextcurr.next!=null && nextcurr.val == nextcurr.next.val){
                while(nextcurr.next!=null && nextcurr.val == nextcurr.next.val){
                    nextcurr = nextcurr.next;
                }
                curr.next = nextcurr.next;
                nextcurr = curr.next;                
            }
            else{
                curr = curr.next;
                nextcurr = nextcurr.next;
            }
            //if(nextcurr == null) break;

        }
        
        return result.next;
        
    }
}


/*


    1 -> 1 -> 1 -> 2 -> 3    
i
         j




*/