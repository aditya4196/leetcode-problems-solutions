class Solution {
    boolean[] cyclicNode;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> result = new ArrayList();
        cyclicNode = new boolean[n];
        
        for(int i=0; i<n; i++){
            isCycle(graph, i, new boolean[n], cyclicNode);
        }
        
        for(int i=0; i<n; i++){
            if(!cyclicNode[i]) result.add(i);
        }
        
        return result;
    }
    
    public boolean isCycle(int[][] graph, int curr, boolean[] visited, boolean[] cyclicNode){
        if(cyclicNode[curr]) return true;
        if(visited[curr]) return false;
        
        cyclicNode[curr] = true;
        visited[curr] = true;
        
        for(int adj : graph[curr]){
            if(isCycle(graph, adj, visited, cyclicNode)) return true;
        }
        
        cyclicNode[curr] = false;
        return false;
    }

}


/*

5 -> (2,4)
(2,4) -> {
    2 -> 
    4 -> (since it is empty)
}


*/