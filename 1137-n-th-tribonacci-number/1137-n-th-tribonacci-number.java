class Solution {
    public int tribonacci(int n) {
        return helper(n, new Integer[n+1]);
    }

    public int helper(int n, Integer[] dp){
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 1;
        if(dp[n]!=null) return dp[n];
        return dp[n] = helper(n-1, dp) + helper(n-2, dp) + helper(n-3, dp);
    }
}