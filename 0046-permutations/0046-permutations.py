class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        

        output = []
        
        def backtrack(idx, nums):
            if idx == len(nums):
                output.append(nums.copy())
            
            for i in range(idx, len(nums)):
                nums[idx],nums[i] = nums[i],nums[idx]
                backtrack(idx+1, nums)
                nums[idx],nums[i] = nums[i],nums[idx]
            
        backtrack(0, nums)
        return output
                
                
        