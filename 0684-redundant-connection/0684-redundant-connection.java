class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
        int n = edges.length;
        
        //makeset
        int[] parent = new int[n+1];
        int[] rank = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
        
        int[] addedEdge = new int[2];
        
        for(int[] edge : edges){
            int findx = findSet(edge[0], parent);
            int findy = findSet(edge[1], parent);
            
            if(findx == findy) addedEdge = new int[]{edge[0],edge[1]};
            union(findx, findy, rank, parent);
        }
        
        return addedEdge;
        
        
        
        
    }
    
    public int findSet(int x, int[] parent){
        if(x == parent[x]) return x;
        else return x = findSet(parent[x], parent);
    }
    
    public void union(int findx, int findy, int[] rank, int[] parent){
        if(rank[findx] > rank[findy]) parent[findy] = findx;
        else if(rank[findy] > rank[findx]) parent[findx] = findy;
        else{
            parent[findx] = findy;
            rank[findy]++;
        }
    }
}