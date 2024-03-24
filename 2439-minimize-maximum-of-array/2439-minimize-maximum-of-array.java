class Solution {
    public int minimizeArrayValue(int[] nums) {
        
        long sum = 0;
        long maxNum = 0;
        
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            maxNum = Math.max(maxNum, (long)Math.ceil((double)sum/(i+1)));
        }
        
        return (int)maxNum;
        
    }
}