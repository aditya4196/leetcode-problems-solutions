class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        output = []
        def backtrack(idx, inner):
            output.append(inner.copy())
            
            for i in range(idx, len(nums)):
                backtrack(i+1, inner + [nums[i]])
        
        backtrack(0, [])
        return output
            
            