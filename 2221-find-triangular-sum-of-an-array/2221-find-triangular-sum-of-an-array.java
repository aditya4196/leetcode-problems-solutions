class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        int end = n-1;
        
        for(int i=1; i<n; i++){
            for(int j=1; j<=end; j++){
                nums[j-1] = (nums[j] + nums[j-1]) % 10;
            }          
            end--;
        }
        
        return nums[0];
        
        
        
        
        
    }
}

/*



*/