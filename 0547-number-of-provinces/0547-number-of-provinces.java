class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        
        int[] rank = new int[n];
        int[] parent = new int[n];
        
        //makeset
        for(int i=0; i<n; i++){
            rank[i] = 0;
            parent[i] = i;
        }
               
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isConnected[i][j] == 1){
                    int findi = findSet(i, parent);
                    int findj = findSet(j, parent);
                    if(findi != findj){
                        union(findi, findj, parent, rank);
                    }
                }
            }
        }
        
        int count = 0;
        for(int i=0; i<n; i++){
            if(parent[i] == i) count++;
        }
        
        return count;
    }
    
    public int findSet(int node, int[] parent){
        if(node == parent[node]) return node;
        else return node = (findSet(parent[node], parent));
    }
    
    public void union(int fn1, int fn2, int[] parent, int[] rank){
        if(rank[fn1] > rank[fn2]){
            parent[fn2] = fn1;
        }
        else if(rank[fn2] > rank[fn1]){
            parent[fn1] = fn2;
        }
        else{
            parent[fn1] = fn2;
            rank[fn2] += 1;
        }
    }
}