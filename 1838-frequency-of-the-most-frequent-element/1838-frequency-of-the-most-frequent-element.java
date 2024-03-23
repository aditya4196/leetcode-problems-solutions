class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        long prefixSum = 0;
        int maxFreq = 1;
        System.out.println(n);
        Arrays.sort(nums);
        int start = 0;
        
        for(int end=0; end<n; end++){
            prefixSum += nums[end];
            long target = nums[end];
            while((long)((end-start+1)*target) - prefixSum > k){
                prefixSum -= nums[start];
                start++;
            }
            
            maxFreq = Math.max(maxFreq, end-start+1);
        }
        
        return maxFreq;
        
    }
}

/*

[1,2,4]
[1,3]
   e
 s 

k = 5


2*2 = 4-3 1 


*/