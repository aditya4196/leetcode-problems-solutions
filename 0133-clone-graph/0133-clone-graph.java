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
    Map<Node, Node> oldToNewMap = new HashMap();
    
    public Node cloneGraph(Node node) {
        dfs(node, oldToNewMap); 
        return oldToNewMap.get(node);
    }
    
    public Node dfs(Node node, Map<Node, Node> nodeMap){
        if(node == null) return null;
        Node newNode = new Node(node.val);
        nodeMap.put(node, newNode);
        
        for(Node neighbor : node.neighbors){
            if(nodeMap.containsKey(neighbor)){
                newNode.neighbors.add(nodeMap.get(neighbor));
            }
            else newNode.neighbors.add(dfs(neighbor, nodeMap));
        }
        
        return newNode;
    }
}


/*

newnode(0) -> 









*/