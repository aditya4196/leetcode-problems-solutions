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
        
        Map<Node, Node> nodesMap = new HashMap();
        Node newhead = new Node(-1);
        Node curr = head;
        Node oldhead = head;
        
        while(oldhead!=null){
            newhead.next = new Node(oldhead.val);
            nodesMap.put(oldhead, newhead.next);
            oldhead = oldhead.next;
            newhead = newhead.next;
        }
        
        newhead = null;

        while(curr!=null){
            newhead = nodesMap.get(curr);
            if(curr.random != null){
                newhead.random = nodesMap.get(curr.random);
            }
            curr = curr.next;
        }
        
        return nodesMap.get(head);
        
        
        
    }
}

/*

[[7,null],[13,0],[11,4],[10,2],[1,0]]


old -> new
7 -> new7

*/