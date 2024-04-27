class Solution {
    int fixlimit;
    int mod = 1000000007;
    public int numberOfStableArrays(int zero, int one, int limit) {
        this.fixlimit = limit;
        Integer[][][][] cache = new Integer[zero+1][one+1][2][201];
        return backtrack(zero, one, -1, 0, cache);
    }
    
    public int backtrack(int zerocount, int onecount, int prevnum, int prevcount, Integer[][][][] cache){
        if(zerocount < 0 || onecount < 0) return 0;
        if(zerocount == 0 && onecount == 0) return 1;
        
        if(prevnum != -1 && cache[zerocount][onecount][prevnum][prevcount] != null) return cache[zerocount][onecount][prevnum][prevcount];
        
        if(this.fixlimit == prevcount){
            if(prevnum == 0){
                if(onecount == 0) return 0;
                else return backtrack(zerocount, onecount-1, 1, 1, cache);
            }
            else{
                if(zerocount == 0) return 0;
                else return backtrack(zerocount-1, onecount, 0, 1, cache);
            }
        }
        
        int totalcount = 0;
        if(prevnum == 0){
            totalcount = (backtrack(zerocount-1, onecount, prevnum, prevcount+1, cache) + backtrack(zerocount, onecount-1, 1, 1, cache)) % mod;
        }
        else{
            totalcount = (backtrack(zerocount-1, onecount, 0, 1, cache) + backtrack(zerocount, onecount-1, prevnum, prevcount+1, cache)) % mod;
        }
        if(prevnum != -1) cache[zerocount][onecount][prevnum][prevcount] = totalcount;
        return totalcount%mod;
        
        
        
    }
}

/*
                                        (1,1,1)
                                        
                                        
                                







*/






