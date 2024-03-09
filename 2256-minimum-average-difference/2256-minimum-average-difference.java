class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long[] prefixSum = new long[n+1];
        int minIndex = -1;
        
        for(int i=0; i<n; i++){
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }
        
        long minAvgDiff = Integer.MAX_VALUE;
        
        for(int i=0; i<n; i++){
            long leftAvg = (prefixSum[i+1] - prefixSum[0])/(i+1);
            long rightAvg = 0;
            if(i < n-1){
                rightAvg = (prefixSum[n] - prefixSum[i+1])/(n-i-1);  
            }

            long avgDiff = Math.abs(leftAvg - rightAvg);
            if(minAvgDiff > avgDiff){
                minAvgDiff = avgDiff;
                minIndex = i;
            }
        }
        
        return minIndex;
        
    }
}

/*

 0 1 2 3 4 5
[2,5,3,9,5,3]


 0 1 2  3  4  5  6 
[0,2,7,10,19,24,27]

avg diff for i - (nums[i+1] - nums[0])/(i+1) - (nums[n] - nums[i+1])/(n-i+1)




*/