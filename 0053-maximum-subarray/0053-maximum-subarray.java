class Solution {
    public int maxSubArray(int[] nums) {
        
        int globalMax = Integer.MIN_VALUE, localMax = 0;
        
        for(int num : nums){
            localMax = Math.max(num + localMax, num);
            globalMax = Math.max(localMax, globalMax);
        }
        
        return globalMax;
        
    }
}