class Solution {
    Deque<int[]> queue;
    int shortestPath = Integer.MAX_VALUE;
    public int shortestBridge(int[][] grid) {
        
        //notate one island different num
        
        queue = new LinkedList();
        boolean notated = false;
        for(int i=0; i<grid.length; i++){
            if(notated) break;
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    dfs(grid, i, j);
                    notated = true;
                    break; 
                }
            }
        }
        
        int[][] zeros = new int[grid.length][grid[0].length];
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for(int i=0; i<zeros.length; i++){
            for(int j=0; j<zeros[0].length; j++){
                if(grid[i][j] != 2){
                    zeros[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while(queue.size() > 0){
            int[] curr = queue.poll();
            
            int x = curr[0];
            int y = curr[1];
            visited[x][y] = true;
            
            for(int[] dir : dirs){
                int newx = x + dir[0];
                int newy = y + dir[1];

                if(newx<0 || newy<0 || newx>=grid.length || newy>=grid[0].length || visited[newx][newy]) continue;
                
                if(grid[newx][newy] == 1){
                    zeros[newx][newy] = zeros[x][y];
                    shortestPath = Math.min(shortestPath, zeros[newx][newy]);
                }
                else if(grid[newx][newy] == 0 && zeros[newx][newy] > (zeros[x][y]+1)){
                    zeros[newx][newy] = zeros[x][y]+1;
                    queue.offer(new int[]{newx, newy});
                } 
            }
        }
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                System.out.print(zeros[i][j] + " ");
            }
            System.out.println();
        }
        
        return shortestPath;
    }
    
    
    
    
    
    public void dfs(int[][] grid, int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == 2 || grid[i][j] == 0) return;
        grid[i][j] = 2;
        queue.offer(new int[]{i,j});
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);  
    }
}