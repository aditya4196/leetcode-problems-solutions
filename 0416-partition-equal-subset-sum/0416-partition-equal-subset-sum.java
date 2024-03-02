class Solution {
    public boolean canPartition(int[] nums) {
        
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum%2 != 0) return false;
        sum/=2;
        
        Arrays.sort(nums);
        return topDown(nums, 0, sum, new Boolean[nums.length][sum+1]);
    }
    
    public boolean topDown(int[] nums, int idx, int target, Boolean[][] memo){
        
        if(target == 0) return true;
        if(target < 0) return false;
        if(idx >= nums.length) return false;
        
        if(memo[idx][target] != null) return memo[idx][target];
        
        boolean chosen = topDown(nums, idx+1, target - nums[idx], memo);
        boolean notChosen = topDown(nums, idx+1, target, memo);
        
        return memo[idx][target] = chosen | notChosen;
        
        
        
    }
}