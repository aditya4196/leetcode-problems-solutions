class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;
        
        int product = 1, count = 0, start = 0;
        
        for(int end = 0; end < nums.length; end++){
            product *= nums[end];
            
            while(start <= end && product >= k){
                product /= (nums[start++]);
            }
            
            count += (end-start+1);
        }
        
        return count;
        
        
    }
}

/*

 0  1. 2. 3
10, 5, 1, 6
e
s

product = 100
k = 100
count = 1

e-s

*/