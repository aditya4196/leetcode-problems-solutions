class Solution:
    def calculate(self, s: str) -> int:
        stack = []
        number = 0
        res = 0
        sign = 1

        for i in s:
            if i.isdigit():
                number = (number * 10) + int(i)
            elif i == '+':
                res += (number * sign)
                number = 0
                sign = 1
            elif i == '-':
                res += (number * sign)
                number = 0
                sign = -1
            elif i == '(':
                stack.append(res)
                stack.append(sign)
                res = 0
                sign = 1
            elif i == ')':
                res += sign * number
                res *= stack.pop()
                res += stack.pop()
                number = 0
            
        return res + number * sign