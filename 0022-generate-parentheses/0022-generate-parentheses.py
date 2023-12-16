class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        
        def backtrack(n, opencount, closecount, s):
            if n*2 == len(s):
                output.append(s)
                return
            
            if closecount < opencount:
                backtrack(n, opencount, closecount+1, s + ')')
            
            if opencount < n:
                backtrack(n, opencount+1, closecount, s + '(')
            
            
        output = []
        backtrack(n, 0, 0, "")
        return output
        
        
        
        
        
        