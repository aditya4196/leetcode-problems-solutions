class Solution {
    public int change(int amount, int[] coins) {
        Integer[][] dp = new Integer[coins.length+1][amount+1];
        return helper(amount, 0, coins, dp);
    }
    
    public int helper(int amount, int idx, int[] coins, Integer[][] dp){
        if(amount == 0) return 1;
        if(idx >= coins.length) return 0;
        if(dp[idx][amount]!=null) return dp[idx][amount];
        int totalWays = 0;
        
        for(int i=idx; i<coins.length; i++){
            if(coins[i] > amount) continue;
            totalWays += helper(amount-coins[i], i, coins, dp);
        }
        
        return dp[idx][amount] = totalWays;
    }
}