class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] isCyclic = new boolean[n];
        
        for(int i=0; i<n; i++){
            dfs(graph, i, visited, isCyclic);
        }
        List<Integer> result = new ArrayList();
        for(int i=0; i<n; i++){
            if(!isCyclic[i]) result.add(i);
        }
        return result;
        
    }
    
    public boolean dfs(int[][] graph, int curr, boolean[] visited, boolean[] isCyclic){
        if(isCyclic[curr]) return true;
        if(visited[curr]) return false;
        
        isCyclic[curr] = true;
        visited[curr] = true;
        
        for(int next : graph[curr]){
            if(dfs(graph, next, visited, isCyclic)) return true;
        }
        
        isCyclic[curr] = false;
        return false;
    }
}