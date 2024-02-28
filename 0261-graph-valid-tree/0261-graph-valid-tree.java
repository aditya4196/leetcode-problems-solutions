class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        //makeset
        int[] parent = new int[n];
        int[] rank = new int[n];
        
        for(int i=0; i<n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
        
        
        for(int[] edge : edges){
            int findx = findSet(edge[0], parent);
            int findy = findSet(edge[1], parent);
            if(findx == findy) return false;
            union(findx, findy, parent, rank);
        }
        
        int connectedComps = 0;
        for(int i=0; i<n; i++){
            if(parent[i] == i && connectedComps++ == 1) return false;
        }
        
        return true;
        
        
    }
    
    public int findSet(int x, int[] parent){
        if(x == parent[x]) return x;
        else return x = findSet(parent[x], parent);
    }
    
    public void union(int findx, int findy, int[] parent, int[] rank){
        if(rank[findx] > rank[findy]) parent[findy] = findx;
        else if(rank[findy] > rank[findx]) parent[findx] = findy;
        else{
            parent[findx] = findy;
            rank[findy]++;
        }
        
    }
}