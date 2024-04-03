

class Solution {
    public Node flatten(Node head) {
        if(head == null) return null;
        
        Node child = flatten(head.child);
        Node next = flatten(head.next);
         
        
        if(child != null) {
            head.next = child;
            child.prev = head;
            while(child.next != null) {
                child = child.next;
            }
            child.next = next;
            if(next != null) next.prev = child;
            head.child = null;
        }
        
        return head;
    }
}