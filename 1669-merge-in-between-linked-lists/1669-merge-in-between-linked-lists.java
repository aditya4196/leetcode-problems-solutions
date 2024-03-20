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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int diff = b - a + 2;
        
        ListNode fast = list1;
        ListNode slow = list1;
        
        for(int i=1; i<=(diff); i++) fast = fast.next;
        
        for(int i=1; i<a; i++){
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = list2;
        while(list2.next != null){
            list2 = list2.next;
        }
        list2.next = fast;
        
        
        return list1;
        
    }
}

/*

[0,1,2,3,4,5,6]
  
     

*/

