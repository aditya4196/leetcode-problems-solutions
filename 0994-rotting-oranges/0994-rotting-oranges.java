class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public int orangesRotting(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque();
        int fresh = 0;
        
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 2) queue.offer(new int[]{i,j});
                else if(grid[i][j] == 1) fresh++;
            }
        }
        
        if(fresh == 0) return 0;
        
        int minutes = -1;
        
        while(queue.size() > 0){
            int size = queue.size();
            
            for(int i=1; i<=size; i++){
                int[] curr = queue.poll();
                for(int[] dir : dirs){
                    
                    int nextx = curr[0] + dir[0];
                    int nexty = curr[1] + dir[1];
                    
                    if(nextx < 0 || nexty < 0 || nextx >= grid.length || nexty >= grid[0].length) continue;
                    if(grid[nextx][nexty] == 1){
                        fresh--;
                        grid[nextx][nexty] = 2;
                        queue.offer(new int[]{nextx,nexty});
                    }
                }
            }
            minutes++;
        }
        return (fresh == 0)?minutes:-1;
        
    }
}