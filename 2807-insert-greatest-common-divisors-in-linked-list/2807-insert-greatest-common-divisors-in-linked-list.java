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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode before = head;
        ListNode after = head.next;
        while(before!=null && after!=null){
            int a = before.val;
            int b = after.val;
            ListNode node = new ListNode(gcd(a,b));
            node.next= after;
            before.next=node;
            before=before.next.next;
            after=after.next;
        }
        return head;
    }
     private int gcd(int a, int b) {
        return (b == 0)?a:(gcd(b,a%b));
    }
}

/*


18 6

18 6


*/