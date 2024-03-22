class Solution {
    int m, n;
    int mod = 1000000007;
    public int numOfArrays(int n, int m, int k) {
        this.n = n;
        this.m = m;
        
        Integer[][][] cache = new Integer[n+1][m+1][k+1];
        return helper(0, 0, k, cache);
        
    }
    
    public int helper(int idx, int maxNum, int remain, Integer[][][] cache){
        if(idx == this.n && remain == 0) return 1;
        if(idx > this.n || remain < 0) return 0;
        
        if(cache[idx][maxNum][remain] != null) return cache[idx][maxNum][remain];
        
        int result = 0;
        for(int num = 1; num <= maxNum; num++){
            result = (result + helper(idx+1, maxNum, remain, cache))%mod;
        }
        
        for(int num = maxNum+1; num <= this.m; num++){
            result = (result + helper(idx+1, num, remain-1, cache)) % mod;
        }
        
        return cache[idx][maxNum][remain] = result;
        
    }
}