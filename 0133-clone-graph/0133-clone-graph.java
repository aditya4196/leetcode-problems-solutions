/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> oldNewMap = new HashMap();
    public Node cloneGraph(Node node) {
        return helper(node, oldNewMap);
        
    }
    
    public Node helper(Node node, Map<Node, Node> oldNewMap){
        if(node == null) return null;
        
        Node newnode = new Node(node.val);
        oldNewMap.put(node, newnode);
        
        for(Node neighbor : node.neighbors){
            if(oldNewMap.containsKey(neighbor)){
                Node newneighbor = oldNewMap.get(neighbor);
                newnode.neighbors.add(newneighbor);
            }
            else{
                newnode.neighbors.add(helper(neighbor, oldNewMap));
            }
        }
        return oldNewMap.get(node);
    }
}