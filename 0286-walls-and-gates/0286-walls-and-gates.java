class Solution {
    int count = 0;
    final int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    
    public void wallsAndGates(int[][] rooms) {
        final int m = rooms.length, n = rooms[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(rooms[i][j] == 0){
                  dfs(rooms, i, j);  
                }
            }
        }
        System.out.println(count);
    }
    
    public void dfs(int[][] rooms, int currx, int curry){
        
        for(int[] dir : dirs){
            int nextx = currx + dir[0];
            int nexty = curry + dir[1];
            
            if(nextx<0 || nexty<0 || nextx>=rooms.length || nexty>=rooms[0].length || rooms[nextx][nexty] == -1) continue;
            if(rooms[nextx][nexty] > (rooms[currx][curry] + 1)){
               rooms[nextx][nexty] = rooms[currx][curry] + 1;
               count++;
               dfs(rooms, nextx, nexty);
            }
        
        }
    }
}