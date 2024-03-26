class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        Map<String,Integer> cache = new HashMap();
        return helper(s, 0, k, '*', 0, cache);
        
    }
    
    public int helper(String s, int idx, int k, int prevChar, int prevCount, Map<String,Integer> cache){
        
        if(idx == s.length()) return 0;
        
        String key = String.valueOf(idx) + "-" + String.valueOf(k) + "-" + String.valueOf(prevChar) + "-" + String.valueOf(prevCount);
        if(cache.containsKey(key)) return cache.get(key);
        
        int minLength = Integer.MAX_VALUE;
        
        if(s.charAt(idx) == prevChar){
            if(prevCount == 1 || prevCount == 9 || prevCount == 99){
                int len = 1 + helper(s, idx+1, k, prevChar, prevCount+1, cache);
                cache.put(key, len);
                return len;
            }
            else{
                int len = helper(s, idx+1, k, prevChar, prevCount+1, cache);
                cache.put(key, len);
                return len;
            }
        }
        else{

            //removed
            if(k > 0){
                int removedLength = helper(s, idx+1, k-1, prevChar, prevCount, cache);
                minLength = Math.min(minLength, removedLength);
            }
            
            //notremoved
                int notRemovedLength = 1 + helper(s, idx+1, k, s.charAt(idx), 1, cache);
                minLength = Math.min(minLength, notRemovedLength);
        }
        cache.put(key, minLength);
        return minLength;
    }
}

/*

aaabcccd, k = 2

a - 3
b - 1
c - 3
d - 1

aabbaa
 
 
charstack = [a,a]
numstack =  [1,2]

                ((0,2,0))
          (1,1,0)        (1,2,1)    
        


*/