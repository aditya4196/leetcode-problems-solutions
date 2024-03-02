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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode result = new ListNode(-1);
        ListNode dummy = result;
        
        while(list1!=null && list2!=null){
            if(list1.val <= list2.val){
                dummy.next = list1;
                list1 = list1.next;
            }
            else{
                dummy.next = list2;
                list2 = list2.next;
            }
            dummy = dummy.next;
        }
        
        dummy.next = (list1 == null)?list2:list1;
        
        return result.next;
        
    }
}

/*

1    2 -> 4
     s   
|  / |
1    3 -> 4
          t    


*/