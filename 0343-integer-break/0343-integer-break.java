class Solution {
    public int integerBreak(int n) {
        
        if(n <= 3) return n-1;
        else return helper(n, new Integer[n+1]);
        
    }
    
    public int helper(int n, Integer[] dp){
        if(n <= 3) return n;
        
        if(dp[n] != null) return dp[n];
        int maxProduct = Integer.MIN_VALUE;
        
        for(int i=2; i<=n; i++){
            int product = i*helper(n-i, dp);
            maxProduct = Math.max(maxProduct, product);
        }
        
        
        return dp[n] = (maxProduct == Integer.MIN_VALUE)?-1:maxProduct;
    }
}