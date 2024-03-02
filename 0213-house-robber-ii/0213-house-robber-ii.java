class Solution {
    public int rob(int[] nums) {
        int n =nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        
        return Math.max(recursive(nums, 0, n-2, new Integer[n]), recursive(nums, 1, n-1, new Integer[n]));
    }
    
    public int recursive(int[] nums, int start, int end, Integer[] memo){
        if(end == start) return nums[start];
        if(end == start+1) return Math.max(nums[start], nums[start+1]);
        if(memo[end]!=null) return memo[end];
        
        return memo[end] = Math.max(recursive(nums, start, end-1, memo), nums[end] + recursive(nums, start, end-2, memo));
        
    }
}