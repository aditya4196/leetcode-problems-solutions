class Solution {
    int m, n;
    final int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
    
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        
        //form the island
        this.m = grid.length;
        this.n = grid[0].length;
        
        boolean[][] candidate = new boolean[m][n];
        dfs(grid, row, col, candidate, grid[row][col]);
       
        int[][] result = new int[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                result[i][j] = grid[i][j];
            }
        }
        
        
        
        //color the nodes with the boundary or not inside the component
        for(int i=0; i<this.m; i++){
            for(int j=0; j<this.n; j++){
                if(candidate[i][j] && grid[i][j] != color && (isBoundary(i, j) || isAdjacency(grid, i, j, grid[i][j]))){
                        result[i][j] = color;
                    }
                }
        }
        
        
        
        return result;
        
    }
    
    public void dfs(int[][] grid, int i, int j, boolean[][] visited, int color){
        if(!isValidBounds(i,j) || visited[i][j] || grid[i][j] !=  color) return;
        
        visited[i][j] = true;
        for(int[] dir : dirs){
            int adj_i = i + dir[0];
            int adj_j = j + dir[1];
            dfs(grid, adj_i, adj_j, visited, color);
        }
    }
    
    public boolean isAdjacency(int[][] grid, int i, int j, int color){
        int count = 0;
        for(int[] dir : dirs){
            int adj_i = i + dir[0];
            int adj_j = j + dir[1];
            
            if(isValidBounds(adj_i,adj_j) && grid[adj_i][adj_j] != color) count++;
        }
        
        return count > 0;
    }
    
    public boolean isValidBounds(int i, int j){
        return (i>=0 && j>=0 && i<this.m && j<this.n);
    }
    
    public boolean isBoundary(int i, int j){
        return (i == 0 || j == 0 || i == (this.m-1) || j == (this.n-1));
    }
}