class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int sum = 0;
        int start = 0, minLength = n+1;
        
        for(int end=0; end<n; end++){
            sum += nums[end];
            
            while(sum >= target){
                minLength = Math.min(minLength, end-start+1);
                sum -= nums[start++];
            }
        }
        
        return (minLength == n+1)?0:minLength;
        
        
        
        
        
    }
}


/*

2 3 1 2 4 3
          e
        s
sum = 9



*/