class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        output = []
        
        def backtrack(nums, idx, inner):
            output.append(inner.copy())
            
            for i in range(idx, len(nums)):
                backtrack(nums, i+1, inner + [nums[i]])
            
        backtrack(nums, 0, [])
        return output
        