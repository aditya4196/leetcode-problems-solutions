class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        double maxAvg = 0;
        long totalSum = 0;
        
        for(int i=0; i<k; i++){
            totalSum += nums[i];
        }
        
        maxAvg = (double)totalSum/k;
        
        for(int i=k; i<nums.length; i++){
            totalSum = totalSum + nums[i] - nums[i-k];
            maxAvg = Math.max(maxAvg, (double)totalSum/k);
        }
        
        return maxAvg;
        
    }
}

/*

[1,12,-5,-6,50,3]



*/