class Solution {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        boolean[][] invalid = new boolean[m][n];
        
        for(int i=0; i<m; i++){
            if(!invalid[i][0]) dfs(grid, i, 0, invalid);
            if(!invalid[i][n-1]) dfs(grid, i, n-1, invalid);
        }
        
        for(int i=0; i<n; i++){
            if(!invalid[0][i]) dfs(grid, 0, i, invalid);
            if(!invalid[m-1][i]) dfs(grid, m-1, i, invalid);
        }
        
        
        
        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.println(invalid[i][j] + "-" + grid[i][j]);
                count += (invalid[i][j])?0:grid[i][j];
            }
        }
        
        
        return count;
        
        
        
    }
    
    public void dfs(int[][] grid, int i, int j, boolean[][] invalid){
        if(!isValidBounds(i,j,grid.length,grid[0].length) || grid[i][j] == 0 || invalid[i][j]) return;
        
        invalid[i][j] = true;
        
        for(int[] dir : dirs){
            int nx = i+dir[0];
            int ny = j+dir[1];
            dfs(grid, nx, ny, invalid);
        }
        
    }
    
    
    public boolean isValidBounds(int i, int j, int m, int n){
        return i>=0 && j>=0 && i<m && j<n;
    }
    
    
}