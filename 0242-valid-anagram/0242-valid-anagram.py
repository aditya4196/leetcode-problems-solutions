class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        
        counter = {}
        for letter in s:
            counter[letter] = counter.get(letter,0)+1
        
        for letter in t:
            counter[letter] = counter.get(letter,0)-1
        
        for val in counter:
            if counter[val] != 0:
                return False
        return True
        
        
        
        