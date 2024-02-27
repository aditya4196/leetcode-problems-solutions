class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int maxArea = 0;
        boolean[][] visited = new boolean[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    maxArea = Math.max(maxArea,dfs(grid, i, j, visited));
                }
            }
        }
        
        return maxArea;
    }
    
    public int dfs(int[][] grid, int i, int j, boolean[][] visited){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || visited[i][j] || grid[i][j] == 0) return 0;
        
        visited[i][j] = true;
        return 1 + dfs(grid, i-1, j, visited) + dfs(grid, i+1, j, visited) + dfs(grid, i, j-1, visited) + dfs(grid, i, j+1, visited);
        
    }
}