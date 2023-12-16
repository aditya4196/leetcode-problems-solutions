class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        
        def createString(num):
            list = []
            
            while num > 0:
                list.append(')' if (num&1) else '(')
                num = num >> 1
            return "".join(list)
        
        def backtrack(n, opencount, closecount, num, digits):
            
            if n*2 == digits:
                output.append(createString(num))
                return
            
            if closecount < opencount:
                backtrack(n, opencount, closecount+1, num << 1, digits+1)
                
            
            if opencount < n:
                backtrack(n, opencount+1, closecount, (num << 1)+1, digits+1)
            

        output = []
        backtrack(n, 0, 0, 0, 0)
        return output
        
        
        
        
        
        