class Solution:
    
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        output = []
        def backtrack(inner: List[int], idx: int):
            output.append(inner[:])
            
            for i in range(idx, len(nums)):
                backtrack(inner+[nums[i]], i+1)
        
        backtrack([], 0)
        return output
        
        
        