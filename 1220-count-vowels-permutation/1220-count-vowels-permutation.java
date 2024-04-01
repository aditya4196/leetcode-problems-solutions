class Solution {
    Integer[][] cache;
    int mod = 1000000007;
    public int countVowelPermutation(int n) {
        
        if(n == 1) return 5;
        cache = new Integer[n+1][5];
        int count = 0;

        for(int i=0; i<=4; i++){
            count = (count + (helper(n-1, i))) % mod;
        }
        return count; 
    }
    
    public int helper(int remain, int vowel){
        if(remain == 0){
            return cache[remain][vowel] = 1;
        }
        
        if(cache[remain][vowel] != null) return cache[remain][vowel];
        
        int localCount = 0;
        if(vowel == 0){
            localCount = ((helper(remain-1, 1) + helper(remain-1, 2))%mod + helper(remain-1, 4)) % mod;  
        }
        else if(vowel == 1){
            localCount = (helper(remain-1, 0) + helper(remain-1, 2)) % mod;  
        }
        else if(vowel == 2){
            localCount = (helper(remain-1, 1) + helper(remain-1, 3)) % mod;  
        }
        else if(vowel == 3){
            localCount = helper(remain-1, 2) % mod;  
        }
        else{
            localCount = (helper(remain-1, 2) + helper(remain-1, 3)) % mod;  
        }
        
        return cache[remain][vowel] = localCount;
        
        
    }
}

/*

a -> e
e -> a,i
i -> a,e,o,u
u -> a
o -> i,u

a = 0, e = 1, i = 2, o = 3, u = 4

a -> i + e + u
e -> i + a
i -> e + o
o -> i
u -> i + o







*/