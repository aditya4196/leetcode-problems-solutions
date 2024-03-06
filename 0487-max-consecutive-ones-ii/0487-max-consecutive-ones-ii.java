class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxLength = 0, start = 0, zeroCount = 0;
        
        
        for(int end=0; end<nums.length; end++){
            zeroCount = (nums[end] == 0)?(zeroCount+1):zeroCount;
            
            while(zeroCount > 1){
                zeroCount = (nums[start++] == 0)?(zeroCount-1):zeroCount;
            }
            
            maxLength = Math.max(maxLength, end-start+1);
        }
        
        return maxLength;
        
        
        
    }
}