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
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        HashMap<Node, Node> oldToNewMap = new HashMap();
        return backTrack(node, oldToNewMap);
    }
    
    public Node backTrack(Node node, HashMap<Node, Node> oldToNewMap){
        Node newNode = new Node(node.val);
        oldToNewMap.put(node, newNode);
        
        for(Node neighbor : node.neighbors){
            if(oldToNewMap.containsKey(neighbor)){
                newNode.neighbors.add(oldToNewMap.get(neighbor));
            }
            else{
                newNode.neighbors.add(backTrack(neighbor, oldToNewMap));
            }
        }
        
        return newNode;
    }
}