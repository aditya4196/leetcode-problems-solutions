class Solution {
    
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        setComponent(grid, row, col, grid[row][col], visited);
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(visited[i][j]){
                    if(i == 0 || j == 0 || i == grid.length-1 || j == grid[0].length-1){
                        grid[i][j] = color;
                    }
                    else{
                        
                        for(int[] dir : dirs){
                            int nexti = i + dir[0];
                            int nextj = j + dir[1];
                            if(isValidBound(nexti, nextj, grid.length, grid[0].length) && !visited[nexti][nextj]){
                                grid[i][j] = color;
                                break;
                            }
                        }
                        
                    }
                }
            }
        }
        
        return grid;
        
        
    }
    
    public void setComponent(int[][] grid, int row, int col, int color, boolean[][] visited){
        if(!isValidBound(row, col, grid.length, grid[0].length) || visited[row][col] || grid[row][col] != color) return;
        visited[row][col] = true;
        
        for(int[] dir : dirs){
            int nextrow = row + dir[0];
            int nextcol = col + dir[1];
            setComponent(grid, nextrow, nextcol, color, visited);
        }
    }
    
    public boolean isValidBound(int row, int col, int m, int n){
        return (row >= 0 && col >= 0 && row < m && col < n);
    }
}

/*

[1,2,2]
[2,3,2]

color = 3



*/