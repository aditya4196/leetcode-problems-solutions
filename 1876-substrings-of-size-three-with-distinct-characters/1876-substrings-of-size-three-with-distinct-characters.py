class Solution:
    
    def countGoodSubstrings(self, s: str) -> int:
        
        if len(s) < 3:
            return 0
        def default_zero():
            return 0
        
        freq = defaultdict(default_zero)
        dupcount = 0
        result = 0
        
        for i in range(3):
            freq[s[i]]+=1
            if freq[s[i]] == 2:
                dupcount+=1
        
        if dupcount == 0:
            result += 1
        
        for i in range(3,len(s)):
            freq[s[i]] += 1
            if freq[s[i]] == 2:
                dupcount+=1
            
            freq[s[i-3]] -= 1
            if freq[s[i-3]] == 1:
                dupcount-=1
            
            if dupcount == 0:
                result+=1
        
        return result
            
            
            
            
            
        