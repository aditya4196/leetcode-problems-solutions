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
    public ListNode removeZeroSumSublists(ListNode head) {
        
        ListNode newhead = new ListNode(-1, head);
        ListNode left = newhead;
        int currSum = 0;
        
        while(left != null){
            currSum = 0;
            ListNode right = left.next;
            
            while(right!=null){
                currSum += right.val;
                
                if(currSum == 0){
                    left.next = right.next;
                }
                right = right.next;
            }
            left = left.next;
        }
        
        return newhead.next;
        
    }
}