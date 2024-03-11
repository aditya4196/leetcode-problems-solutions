class LRUCache {
    
    Node head, tail;
    HashMap<Integer, Node> nodeMap;
    private int size;

    public LRUCache(int capacity) {
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        
        size = capacity;
        nodeMap = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
        if(nodeMap.containsKey(key)){
            Node requestedNode = nodeMap.get(key);
            removeNode(requestedNode);
            addNodeAfterHead(requestedNode);
            return requestedNode.value;
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        
        if(nodeMap.containsKey(key)){
            Node node = nodeMap.get(key);
            node.value = value;
            removeNode(node);
            addNodeAfterHead(node);
        }
        else{
            if(size == 0){
                Node endNode = tail.prev;
                removeNode(endNode);
                nodeMap.remove(endNode.key);
            }
            else{
                size--;
            }

            Node newnode = new Node(key, value);
            addNodeAfterHead(newnode);
            nodeMap.put(key, newnode); 
        }
    }
    
    public void addNodeAfterHead(Node node){
        Node nextNode = head.next;
        head.next = node;
        node.prev = head;
        nextNode.prev = node;
        node.next = nextNode;
    }
    
    public void removeNode(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    
//     public void remove(Node node){
        
//     }
}

class Node{
    int value;
    int key;
    Node prev;
    Node next;
    
    public Node(int key, int value){
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/*

size = 2
(2,node6)
(1,node5)
(1, )

h - node2 - node5 - t

addNodeAfterHead
removeHeadAtEnd
updateCache



*/