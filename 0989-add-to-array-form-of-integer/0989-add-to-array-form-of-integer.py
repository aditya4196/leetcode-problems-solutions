class Solution:
    def addToArrayForm(self, num: List[int], k: int) -> List[int]:
        
        carry = 0
        n = len(num)
        result = []
        
        for i in range(n-1,-1,-1):
            print(num[i])
            rem = k%10
            sum = rem + num[i] + carry
            if sum > 9:
                sum%=10
                carry = 1
            else:
                carry = 0
            result.insert(0,sum)
            k//=10
        
        while k > 0:
            rem = k%10
            sum = rem + carry
            if sum > 9:
                sum%=10
                carry = 1
            else:
                carry = 0
            result.insert(0,sum)
            k//=10
        
        if carry == 1:
            result.insert(0,1)
        
        return result
        