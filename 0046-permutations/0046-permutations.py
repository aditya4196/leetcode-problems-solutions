class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:

        def backtrack(inner):
            if len(inner) == len(nums):
                output.append(inner)
                return

            for i in range(0, len(nums)):
                if nums[i] not in visited:
                    visited.add(nums[i])
                    backtrack(inner + [nums[i]])
                    visited.remove(nums[i])
            
        output = []
        visited = set()
        backtrack([])
        return output
            
            
        
        