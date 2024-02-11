class Solution:
    def maxFrequency(self, nums: List[int], k: int) -> int:
        nums.sort()
        start = 0
        maxfreq = 0
        presum = 0
        
        for end in range(len(nums)):
            presum += nums[end]
            
            while (end-start+1)*nums[end] - presum > k:
                presum -= nums[start]
                start+=1
            
            maxfreq = max(maxfreq, end-start+1)
        
        return maxfreq
        
        