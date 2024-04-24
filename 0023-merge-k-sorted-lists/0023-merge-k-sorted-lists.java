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
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists.length == 0) return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a,b) -> (Integer.compare(a.val, b.val)));
        
        for(ListNode list : lists){
            if(list != null) pq.offer(list);
        }
        
        if(pq.size() == 0) return null;
        
        ListNode output = new ListNode(-1);
        ListNode dummy = output;
        
        while(pq.size() > 0){
            ListNode currPoll = pq.poll();
            dummy.next = currPoll;
            dummy = dummy.next;
            if(currPoll.next != null) pq.offer(currPoll.next);
        }
        
        return output.next;
        
    }
}