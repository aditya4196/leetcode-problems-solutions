class Solution {
    public boolean canJump(int[] nums) {
        
        int n = nums.length;
        Boolean[] memo = new Boolean[n];
        memo[n-1] = true;
        
        return recursive(nums, 0, memo);
    }
    
    public boolean recursive(int[] nums, int idx, Boolean[] memo){
        if(idx == nums.length-1) return true;
        if(nums[idx] == 0) return false;
        if(memo[idx]!=null) return memo[idx];
        
        boolean reachable = false;
        
        for(int i=idx+1; i<= Math.min(nums.length-1, idx + nums[idx]); i++){
            reachable |= recursive(nums, i, memo);
        }
        return memo[idx] = reachable;
    }
}

/*

2 3 1 1 4
  i

*/