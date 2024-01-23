class Solution:
    def isAnagram(self, s: str, t: str) -> bool:  
        counter = {}
        for letter in s:
            counter[letter] = counter.get(letter,0)+1
        
        for letter in t:
            counter[letter] = counter.get(letter,0)-1
            if counter[letter] < 0:
                return False
        
        return (len(s) == len(t))

        
        
        
        