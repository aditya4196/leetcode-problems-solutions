class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        
        def createString(binstr):
            list = []
            for i in range(0,(n*2)):
                list.append('(' if binstr[i] == '1' else ')')
            return "".join(list)
                
                
        def backtrack(n, opencount, closecount, num):
            if n*2 == len(str(num)):
                output.append(createString(str(num)))
                return
            
            if closecount < opencount:
                backtrack(n, opencount, closecount+1, num*10)
                
            
            if opencount < n:
                backtrack(n, opencount+1, closecount, num*10+1)
            

        output = []
        backtrack(n, 0, 0, 0)
        return output
        
        
        
        
        
        