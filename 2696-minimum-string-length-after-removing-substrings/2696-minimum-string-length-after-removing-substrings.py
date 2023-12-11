class Solution:
    def minLength(self, s: str) -> int:
        stack = []
        def check(sub):
            return sub == "AB" or sub == "CD"
        
        for c in s:
            if stack and check(str(stack[-1]+c)):
                stack.pop()
            else:
                stack.append(c)

        return len(stack)
            
        