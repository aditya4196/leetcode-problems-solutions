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
    public void reorderList(ListNode head) {
        
        //get the middle of the list
        boolean isOddLen = false;
        ListNode fast = head, slow = head;
        
        if(head == null || head.next == null || head.next.next == null) return;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(fast != null){
            slow = slow.next;
            isOddLen = true;
        }
        
        ListNode back = reverseList(slow);
        ListNode front = head;
        ListNode nback = back.next;
        ListNode nfront = front.next;

        
        while(back!=null){
            nfront = front.next;
            nback = back.next;
            front.next = back;
            back.next = nfront;
            front = nfront;
            back = nback;
            if(!isOddLen && back.next == null) break;
        }
        
        if(isOddLen){
            front.next = null;
        }

    }
    
    public ListNode reverseList(ListNode head){
        ListNode prev = null, nextcurr = null;
        ListNode curr = head;
        
        while(curr!=null){
            nextcurr = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextcurr;
        }
        
        return prev;
    }
}