class Solution {
    public int rob(int[] nums) {
        return recursive(nums, nums.length-1, new Integer[nums.length]);
    }
    
    public int recursive(int[] nums, int i ,Integer[] dp){
        if(i == 0) return nums[0];
        if(i == 1) return Math.max(nums[0], nums[1]);
        if(dp[i]!=null) return dp[i];
        
        return dp[i] = Math.max(recursive(nums, i-1, dp), nums[i] + recursive(nums, i-2, dp));
        
    }
}