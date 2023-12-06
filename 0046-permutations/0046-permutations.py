class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:

        def backtrack(inner, visited):
            if len(inner) == len(nums):
                output.append(inner)
                return

            for i in range(0, len(nums)):
                if nums[i] not in visited:
                    backtrack(inner + [nums[i]], visited | {nums[i]})
            
        output = []
        backtrack([], set())
        return output
            
            
        
        