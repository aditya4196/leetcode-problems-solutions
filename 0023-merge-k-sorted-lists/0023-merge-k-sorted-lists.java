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
        
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a,b) -> (a.val - b.val));
        
        for(ListNode list: lists){
            if(list != null) pq.offer(list);
        }
        
        if(pq.size() == 0) return null;
        
        ListNode result = new ListNode(-1);
        ListNode dummy = result;
        
        while(pq.size() > 0){
            ListNode curr = pq.poll();
            dummy.next = curr;
            dummy = dummy.next;
            if(curr.next != null) pq.offer(curr.next);
        }
        
        return result.next;
        
        
        
    }
}

/*


1 -> 4 -> 5
1 -> 3 -> 4
2 -> 6


pq = [4,1,2]



*/