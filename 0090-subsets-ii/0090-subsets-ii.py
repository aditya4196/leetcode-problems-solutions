class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:

        output = []
        def backtrack(idx, inner):
            output.append(inner.copy())
            
            for i in range(idx, len(nums)):
                if i > idx and nums[i] == nums[i-1]:
                    continue
                backtrack(i+1, inner + [nums[i]])
        
        nums.sort()
        backtrack(0,[])
        return output
        
        
        