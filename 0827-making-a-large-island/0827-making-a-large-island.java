class Solution {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public int largestIsland(int[][] grid) {
        //dfs to form islands and the dsu instance
        int n = grid.length;
        
        DSU dsu = new DSU(n);
        boolean[][] visited = new boolean[n][n];
        boolean hasZeros = false;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    dfs(grid, i, j, visited, dsu);
                }
                if(grid[i][j] == 0) hasZeros = true;
            }
        }
        
        if(!hasZeros) return n*n;
        
        // for(int i=0; i<n*n; i++){
        //     System.out.println(i + "-" + dsu.parent[i] + "-" + dsu.size[i]);
        // }
        
        int maxArea = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                
                if(grid[i][j] == 0){
                    int count = 1;
                    Set<Integer> set = new HashSet();
                    
                    for(int[] dir : dirs){
                        int adj_i = i + dir[0];
                        int adj_j = j + dir[1];
                        int adj_idx = adj_i*n + adj_j;
                        if(isValidBounds(adj_i, adj_j, n) 
                           && grid[adj_i][adj_j] == 1 && !set.contains(dsu.parent[adj_idx])){
                            count += dsu.size[dsu.parent[adj_idx]];
                            set.add(dsu.parent[adj_idx]);
                        }
                     }
                    System.out.println(count);
                    maxArea = Math.max(maxArea, count);
                }   
            }
        }
        
        return maxArea;
        
        
        
    }
    
    public boolean isValidBounds(int i, int j, int n){
        return (i>=0 && j>=0 && i<n && j<n);
    }
    
    public void dfs(int[][] grid, int i, int j, boolean[][] visited, DSU dsu){
        visited[i][j] = true;
        int idx = i*grid.length + j;
        
        for(int[] dir : dirs){
            int adj_i = i + dir[0];
            int adj_j = j + dir[1];
            int adj_idx = adj_i*grid.length + adj_j;
            
            if(isValidBounds(adj_i, adj_j, grid.length) && !visited[adj_i][adj_j] && grid[adj_i][adj_j] == 1){
                dsu.unionBySize(idx, adj_idx);
                dfs(grid, adj_i, adj_j, visited, dsu);
            }
        }
    }
}

class DSU{
    int[] parent;
    int[] size;
    
    public DSU(int n){
        this.parent = new int[n*n+1];
        this.size = new int[n*n+1];
        for(int i=0; i<n*n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    public int findParent(int node){
        if(node == parent[node]) return node;
        else return node = findParent(parent[node]);
    }
    
    public void unionBySize(int node1, int node2){
        int fnode1 = findParent(node1);
        int fnode2 = findParent(node2);
        
        if(fnode1 == fnode2) return;
        
        if(size[fnode1] >= size[fnode2]){
            parent[fnode2] = fnode1;
            size[fnode1] += size[fnode2];
        }
        else if(size[fnode2] > size[fnode1]){
            parent[fnode1] = fnode2;
            size[fnode2] += size[fnode1];
        }
    }
    
}

/*

[1,1,0]
[0,0,1]
[1,0,1]


idx = i*n+j
i,j = idx/n,id%n


*/