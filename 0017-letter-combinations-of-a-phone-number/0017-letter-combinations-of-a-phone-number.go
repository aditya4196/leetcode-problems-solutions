class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        
        def backtrack(digits, id, letterDict, s):
            nonlocal output
            if id == len(digits):
                output.append(s)
                return
            
            for i in range(len(letterDict[digits[id]])):
                backtrack(digits, id+1, letterDict, s + letterDict[digits[id]][i])
        
        letterDict = {}
        letterDict['2'] = 'abc'
        letterDict['3'] = 'def'
        letterDict['4'] = 'ghi'
        letterDict['5'] = 'jkl'
        letterDict['6'] = 'mno'
        letterDict['7'] = 'pqrs'
        letterDict['8'] = 'tuv'
        letterDict['9'] = 'wxyz'
        
        output = []
        
        backtrack(digits, 0, letterDict, '')
        return [] if len(digits) == 0 else output
        
        
        
        
        
        
        