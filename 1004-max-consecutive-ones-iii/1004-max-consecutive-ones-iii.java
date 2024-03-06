class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int start = 0, zeros = 0, maxLength = 0;
        
        for(int end=0; end<nums.length; end++){
            zeros = (nums[end] == 0)?(zeros+1):zeros;
            
            while(zeros > k){
                zeros = (nums[start++] == 0)?(zeros-1):zeros;
            }
            
            maxLength = Math.max(maxLength, end-start+1);
        }
        
        return maxLength;
        
        
        
    }
}