class Solution {
    public int lengthOfLIS(int[] nums) {
        Integer[][] dp = new Integer[nums.length][nums.length+1];
        return topDown(nums, 0, -1, dp);
    }
    
    public int topDown(int[] nums, int idx, int prev, Integer[][] dp){
        if(idx == nums.length) return 0;
        if(dp[idx][prev+1]!=null) return dp[idx][prev+1];
        
        if(prev!=-1 && nums[prev] >= nums[idx]){
            return dp[idx][prev+1] = topDown(nums, idx+1, prev, dp);
        }
        
        return dp[idx][prev+1] = Math.max(1 + topDown(nums, idx+1, idx, dp), topDown(nums, idx+1, prev, dp));
    }
}

/*

10,9,2,5,3,7,101,18

                10
                
       null,10         null,9
     
    10,101.  10,18
    


*/