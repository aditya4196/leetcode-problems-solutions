class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int n = matrix.length;
        int minSum = Integer.MAX_VALUE;
        Integer[][] memo = new Integer[n][n];
        
        for(int i=0; i<n; i++){
            minSum = Math.min(minSum, traverse(matrix, 0, i, memo));
        }
        return minSum;
    }
    
    public int traverse(int[][] matrix, int row, int col, Integer[][] memo){      
        if(col < 0 || col > matrix.length-1) return 10000;
        if(row == matrix.length-1) return matrix[row][col];
        if(memo[row][col] != null) return memo[row][col];
        
        int left = traverse(matrix, row+1, col-1, memo);
        int right = traverse(matrix, row+1, col+1, memo);
        int down = traverse(matrix, row+1, col, memo);
        
        return memo[row][col] = matrix[row][col] + Math.min(left, Math.min(right, down));
    }
}