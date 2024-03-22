class Solution {
    int[][] dp;
    int n, m;
    int[] dx = {0, 1};
    int[] dy = {1, 0};
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        n = obstacleGrid.length;
        m = obstacleGrid[0].length;
        
        if (obstacleGrid[0][0] == 1) return 0;
        if (n == 1 && m == 1) return 1;
        
        dp = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        dp[0][0] = 1;
        
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            
            for (int i = 0; i < 2; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                
                if (xx < 0 || xx >= n || yy < 0 || yy >= m || obstacleGrid[xx][yy] == 1) continue;
                
                if (dp[xx][yy] == 0) q.offer(new int[]{xx, yy});
                dp[xx][yy] += dp[x][y];
            }
        }
        
        return dp[n - 1][m - 1];
    }
}