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
        
        ListNode curr = head;
        if(head == null || head.next == null) return head;
        
        for(ListNode comparing = head; comparing != null; comparing = comparing.next){
            if(curr.val != comparing.val){
                curr.next = comparing;
                curr = comparing;
            }
        }
        curr.next = null;
        return head;
        
    }
}

/*

1 -> 2 -> 3 -> 3
     i
     j



*/