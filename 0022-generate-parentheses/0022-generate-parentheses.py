class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        
        def backtrack(n, opencount, closecount, innerlist):
            if n*2 == len(innerlist):
                output.append("".join(innerlist))
                return
            
            if closecount < opencount:
                innerlist.append(')')
                backtrack(n, opencount, closecount+1, innerlist)
                innerlist.pop()
            
            if opencount < n:
                innerlist.append('(')
                backtrack(n, opencount+1, closecount, innerlist)
                innerlist.pop()
            
            
        output = []
        backtrack(n, 0, 0, [])
        return output
        
        
        
        
        
        