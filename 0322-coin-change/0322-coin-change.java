class Solution {
    public int coinChange(int[] coins, int amount) {
        
        if(amount == 0) return 0;
        
        int count = topDown(coins, amount, new Integer[amount+1]);
        return (count == 0)?(-1):count;
        
    }
    
    public int topDown(int[] coins ,int amount, Integer[] memo){
        
        if(amount == 0) return 0;
        if(amount < 0) return -1;
    
        if(memo[amount]!=null) return memo[amount];
        
        int minCoins = Integer.MAX_VALUE;
        for(int i=0; i<coins.length; i++){

            int totalCoins = topDown(coins, amount-coins[i], memo);
            if(totalCoins != -1) minCoins = Math.min(minCoins, totalCoins+1);
        }
        
        return memo[amount] = (minCoins == Integer.MAX_VALUE)?-1:(minCoins);
    }
}