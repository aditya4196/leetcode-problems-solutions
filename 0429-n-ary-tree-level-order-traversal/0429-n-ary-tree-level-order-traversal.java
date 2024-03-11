/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        
        List<List<Integer>> result = new ArrayList();
        if(root == null) return result;
        
        Deque<Node> queue = new ArrayDeque();
        Node curr = root;
        queue.offer(root);
        
        while(queue.size() > 0){
            int size = queue.size();
            List<Integer> level = new LinkedList();
            
            for(int i=1; i<=size; i++){
                curr = queue.poll();
                level.add(curr.val);
                for(Node child : curr.children){
                    queue.offer(child);
                }
            }
            
            result.add(level);
        }
        
        return result;
        
    }
}