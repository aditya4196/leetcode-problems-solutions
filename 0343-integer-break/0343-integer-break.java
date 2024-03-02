class Solution {
    int n;
    public int integerBreak(int n) {
        this.n = n;
        if(n <= 3) return n-1;
        return recursive(n, new Integer[n+1]);
    }
    
    public int recursive(int target, Integer[] memo){
        if(target <= 3) return target;
        
        if(memo[target]!=null) return memo[target];
        
        int maxProduct = target;
        
        for(int i=2; i<target; i++){
            int product = i * recursive(target-i, memo);
            maxProduct = Math.max(maxProduct, product);
        }
        
        return memo[target] = maxProduct;
    }
}

/*

weight = 5

target = 1

product = 1
mp = 1

1 2 3 4

                



*/