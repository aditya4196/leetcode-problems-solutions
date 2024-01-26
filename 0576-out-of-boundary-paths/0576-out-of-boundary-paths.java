class Solution {
    int mod = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int result = traverse(m, n, maxMove, startRow, startColumn, new Integer[m][n][maxMove+1]);
        return result;
        
    }
    
    public int traverse(int m, int n, int maxmoves, int sr, int sc, Integer[][][] memo){
        if(sr<0 || sc<0 || sr == m || sc == n) return 1;
        if(maxmoves == 0) return 0;
        if(memo[sr][sc][maxmoves]!=null) return memo[sr][sc][maxmoves];
        int paths = (
            (traverse(m,n,maxmoves-1,sr+1,sc, memo) 
            + traverse(m,n,maxmoves-1,sr-1,sc, memo))%mod
            + (traverse(m,n,maxmoves-1,sr,sc+1, memo) 
            + traverse(m,n,maxmoves-1,sr,sc-1, memo))%mod)%mod;
        return memo[sr][sc][maxmoves] = paths%mod;
    }
}