/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        
        if(head == null) return null;
        
        Node childNode = flatten(head.child);
        Node nextNode = flatten(head.next);
        
        if(childNode != null){
            childNode.prev = head;
            head.next = childNode;
            
            while(childNode.next != null) childNode = childNode.next;
            childNode.next = nextNode;
            if(nextNode != null) nextNode.prev = childNode;
            head.child = null;
        }
        
        return head;
        
    }
}