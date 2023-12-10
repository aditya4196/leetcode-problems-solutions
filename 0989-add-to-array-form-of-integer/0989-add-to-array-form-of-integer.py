class Solution:
    def addToArrayForm(self, num: List[int], k: int) -> List[int]:
        
        carry = 0
        n = len(num)
        result = []
        i = n-1
        
        while i>=0 or k>0:
            rem = k%10
            val = 0 if i<0 else num[i]
            sum = rem + val + carry
            if sum > 9:
                sum%=10
                carry = 1
            else:
                carry = 0
            result.insert(0,sum)
            i-=1
            k//=10
        
        if carry == 1:
            result.insert(0,1)
        
        return result
        