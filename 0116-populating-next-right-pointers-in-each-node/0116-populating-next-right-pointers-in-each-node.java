/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        
        if(root == null) return root;
        Deque<Node> queue = new ArrayDeque();
        Node curr = root;
        queue.offer(curr);
        
        while(queue.size() > 0){
            int size = queue.size();
            
            Node prevNode = null;
            for(int i=1; i<=size; i++){
                curr = queue.poll();
                if(prevNode != null) prevNode.next = curr;
                prevNode = curr;
                
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right!=null) queue.offer(curr.right);
            }
        }
        
        return root;
        
        
        
        
    }
}