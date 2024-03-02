class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        Integer[] memo = new Integer[n];
        //memo[n-1] = 0;
        
        return recursive(nums, 0, memo);
        
    }
    
    public int recursive(int[] nums, int idx, Integer[] memo){
        if(idx == nums.length-1) return 0;
        if(nums[idx] == 0) return nums.length+1;
        if(memo[idx]!=null) return memo[idx];
        
        int minSteps = nums.length+1;
        
        for(int i=idx+1; i<=Math.min(nums.length-1, idx+nums[idx]); i++){
            int totalSteps = 1 + recursive(nums, i, memo);
            minSteps = Math.min(minSteps, totalSteps);
        }
        
        return memo[idx] = minSteps;
        
        
        
        
        
        
    }
}