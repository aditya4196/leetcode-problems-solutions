class Solution {
    public int maxProfit(int[] prices) {
        
        int minPrice = prices[0];
        int maxProfit = 0;
        
        for(int price : prices){
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        
        return maxProfit;
        
    }
}

/*

[7,1,5,3,6,4]
         i
 
 p = 2
 m = 1
 mp = 4


*/