class Solution:
    def partitionString(self, s: str) -> int:
        
        def default_zero():
            return 0
        j = 0
        freq = defaultdict(default_zero)
        count = 0
        
        for i in range(0,len(s)):
            if(freq[s[i]] == 1):
                freq[s[i]]+=1
                count+=1
                while j < i:
                    freq[s[j]]-=1
                    j+=1
            else:
                freq[s[i]]+=1
        
        return count+1
                    
            
        
        