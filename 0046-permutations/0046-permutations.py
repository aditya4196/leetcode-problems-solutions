class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        def backtrack(inner, visited):
            if len(inner) == len(nums):
                output.append(inner)
                return

            for num in nums:
                if num not in visited:
                    backtrack(inner + [num], visited | {num})
            
        output = []
        backtrack([], set())
        return output
            
            
        
        