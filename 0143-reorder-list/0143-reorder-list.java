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
        
        if(head == null || head.next == null || head.next.next == null ) return;
        boolean isEvenLen = false;
        //get the middle of the list
        
        ListNode fast = head, slow = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(fast == null) isEvenLen = true;
        else slow = slow.next;
        
        //get reverse of linkedlist
        ListNode revhead = reverseHead(slow);
        ListNode currhead = head;
        
        //Reordering
        ListNode fst = head, sec = revhead;
        ListNode fstnext = fst.next, secnext = sec.next;

        
        while(sec!=null){
            fstnext = fst.next;
            secnext = sec.next;
            fst.next = sec;
            sec.next = fstnext;
            fst = fstnext;
            sec = secnext;
            if(isEvenLen && sec.next == null) break;
        } 
        
        if(!isEvenLen) fst.next = null;
        
    }
    
    public boolean endCondition(ListNode fstnext, ListNode sec, boolean isEvenLen){
        if(isEvenLen) return (fstnext != null);
        else return (sec!=null);
    }
    
    public ListNode reverseHead(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode newhead = reverseHead(head.next);
        head.next.next = head;
        head.next = null;
        return newhead;
    }
    
    
}

/*

1 -> 2 <- 3 <- 4
                   f

1 -> 2
     f      
4 -> 5 -> null
     s

1 -> 4 -> 2
          f
3 
s


*/