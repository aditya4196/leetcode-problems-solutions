class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, 0);
        
        for(int i=0; i<n; i++){
            if(color[i] == 0){
                color[i] = 1;
                if(!dfs(i, graph, color)) return false;
            }
        }
        
        return true;
        
    }
    
    public boolean dfs(int curr, int[][] graph, int[] color){

        for(int neighbor : graph[curr]){
            if(color[neighbor] == 0){
                color[neighbor] = -1*color[curr];
                if(!dfs(neighbor, graph, color)) return false;
            }
            else if(color[neighbor] == color[curr]) return false;
        }
        
        return true;
    }
}