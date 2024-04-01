class Solution {
    int m,n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        
        boolean[][] visited = new boolean[m][n];
        int islandCount = 0;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(grid, i, j, visited);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }
    
    public void dfs(char[][] grid, int row, int col, boolean[][] visited){
        if(!isValidBounds(row, col) || visited[row][col] || grid[row][col] == '0') return;
        
        visited[row][col] = true;
        dfs(grid, row-1, col, visited);
        dfs(grid, row+1, col, visited);
        dfs(grid, row, col-1, visited);
        dfs(grid, row, col+1, visited);
        
    }
    
    public boolean isValidBounds(int row, int col){
        return row >= 0 && col >= 0 && row < m && col < n;
    }
}