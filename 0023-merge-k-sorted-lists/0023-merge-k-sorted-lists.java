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

        for(ListNode list : lists){
            if(list!=null) pq.offer(list);
        }

        ListNode output = new ListNode();
        ListNode dummy = output;

        while(pq.size() > 0){
            ListNode priList = pq.poll();
            dummy.next = new ListNode(priList.val);
            dummy = dummy.next;
            if(priList.next!=null) pq.offer(priList.next);
        }

        return output.next;


        
    }
}