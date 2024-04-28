class Solution {
    public int minPathSum(int[][] grid) {
        //ds
        int m = grid.length, n = grid[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i == 0 && j == 0) continue;
                if(i == 0 && j > 0){
                    grid[0][j] = grid[0][j] + grid[0][j-1];
                }
                else if(j == 0 && i > 0){
                    grid[i][0] = grid[i][0] + grid[i-1][0];
                }
                else{
                    grid[i][j] = grid[i][j] + Math.min(grid[i-1][j], grid[i][j-1]);
                }
            }
        }

        return grid[m-1][n-1];
    }
}

/*

grid
[1, 3, 1],
[1, 5, 1],
[4, 2, 1]





recursion relation :
dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i]][j-1])



//base case -







*/