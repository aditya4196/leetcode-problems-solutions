class Solution {
    public int minimizeArrayValue(int[] nums) {
        
        long maxValue = 0;
        long currSum = 0;
        
        for(int i=0; i<nums.length; i++){
            currSum += nums[i];
            maxValue = Math.max(maxValue, (long)Math.ceil((double)currSum/(double)(i+1)));
        }

        return (int)maxValue;
        
    }
}


/*

[3,7,1,6]

[5,5,1,6]




*/