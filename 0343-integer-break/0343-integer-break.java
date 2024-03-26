class Solution {
    public int integerBreak(int n) {
        if(n <= 3) return n-1;
        Integer[] dp = new Integer[n+1];
        return helper(n, dp);
        
    }
    
    public int helper(int n, Integer[] dp){
        if(n <= 3) return n;
        
        if(dp[n] != null) return dp[n];
        int maxProduct = n;
        for(int br = 2; br <= n; br++){

            int product = br*helper(n-br,dp);
            maxProduct = Math.max(maxProduct, product);

        }
        
        return dp[n] = maxProduct;
    }
}