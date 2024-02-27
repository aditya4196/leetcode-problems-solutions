class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Deque<int[]> pacificQueue = new ArrayDeque();
        Deque<int[]> atlanticQueue = new ArrayDeque();
        int m = heights.length, n = heights[0].length;
        
        //fill in the queues
        for(int i=0; i<m; i++){
            pacificQueue.offer(new int[]{i,0});
            atlanticQueue.offer(new int[]{i, n-1});
        }
        
        for(int i=0; i<n; i++){
            pacificQueue.offer(new int[]{0, i});
            atlanticQueue.offer(new int[]{m-1, i});
        }
        
        boolean[][] atlanticReachable = bfs(atlanticQueue, heights);
        boolean[][] pacificReachable = bfs(pacificQueue, heights);
        
        List<List<Integer>> result = new ArrayList();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(atlanticReachable[i][j] && pacificReachable[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }
    
    
    public boolean[][] bfs(Deque<int[]> queue, int[][] heights){
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int m = heights.length, n = heights[0].length;
        
        boolean[][] reachable = new boolean[m][n];
        
        while(queue.size() > 0){
            int size = queue.size();
            
            for(int i=1; i<=size; i++){
                int[] curr = queue.poll();
                reachable[curr[0]][curr[1]] = true;
                
                for(int[] dir : dirs){
                    int nx = curr[0] + dir[0];
                    int ny = curr[1] + dir[1];
                    
                    if(isValidBounds(nx, ny, m, n) && !reachable[nx][ny] && heights[nx][ny] >= heights[curr[0]][curr[1]]){
                        queue.offer(new int[]{nx,ny});
                    }
                    
                }
            }
        }
        
        return reachable;
    }
    
    public boolean isValidBounds(int i, int j, int m, int n){
        return i>=0 && j>=0 && i<m && j<n;
    }
}