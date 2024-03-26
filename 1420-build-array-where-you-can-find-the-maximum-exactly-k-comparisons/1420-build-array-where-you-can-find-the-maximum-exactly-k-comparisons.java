class Solution {
    int m,n;
    int mod = 1000000007;
    public int numOfArrays(int n, int m, int k) {
        this.m = m;
        this.n = n;
        Integer[][][] dp = new Integer[n+1][m+1][k+1];
        return helper(0,0,k,dp);
    }
    
    public int helper(int count, int maxSoFar, int cost, Integer[][][] dp){
        if(count == this.n && cost == 0) return 1;
        if(count == this.n || cost < 0) return 0;

        if(dp[count][maxSoFar][cost] != null) return dp[count][maxSoFar][cost];
        
        
        int result = 0;
        
        for(int i=1; i<=maxSoFar; i++){
            result = (result + helper(count+1, maxSoFar, cost, dp))%mod;
        }
        
        for(int i=maxSoFar+1; i<=m; i++){
            result = (result + helper(count+1, i, cost-1, dp))%mod;
        }
        
        return dp[count][maxSoFar][cost] = result;
    }
}

/*

 n = 4
 m = 3
 k = 0
            
                        ()

[1,2,3]

[1,1,1,1]
[2,1,1,1]
[3,2,2,2]
[]




*/