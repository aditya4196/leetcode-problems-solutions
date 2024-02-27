class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        
        int m = image.length, n = image[0].length;
        if(image[sr][sc] == color) return image;
        
        Deque<int[]> queue = new ArrayDeque();
        int oldColor = image[sr][sc];
        image[sr][sc] = color;
        queue.offer(new int[]{sr, sc});
        
        while(queue.size() > 0){
            int size = queue.size();
            
            for(int i=1; i<=size; i++){
                int[] curr = queue.poll();
                
                for(int[] dir : dirs){
                    int nextr = curr[0] + dir[0];
                    int nextc = curr[1] + dir[1];
                    
                    if(nextr < 0 || nextc < 0 || nextr >= m || nextc >= n || image[nextr][nextc] != oldColor) continue;
                    image[nextr][nextc] = color;
                    queue.offer(new int[]{nextr, nextc});
                }
            }
        }
        
        return image;
        
        
        
        
        
    }
}