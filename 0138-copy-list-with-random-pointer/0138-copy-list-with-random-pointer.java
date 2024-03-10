/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        Node newhead = new Node(-1);
        Node curr = head;
        HashMap<Node, Node> oldtoNewMap = new HashMap();
        
        while(curr!=null){
            newhead.next = new Node(curr.val);
            oldtoNewMap.put(curr, newhead.next);
            curr = curr.next;
            newhead = newhead.next;
        }
        
        
        
        curr = head;
        while(curr!=null){
            newhead = oldtoNewMap.get(curr);
            newhead.random = oldtoNewMap.get(curr.random);
            curr = curr.next;
        }
        
        return oldtoNewMap.get(head);
        
        
        
    }
}


/*

new7 to old7

7 -> 13 -> 11 -> 10 -> 1 -> null

newNode(oldnode.val)
map.put(oldNode, newNode)




*/