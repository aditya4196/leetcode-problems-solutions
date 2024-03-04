class Solution {
    public boolean canJump(int[] nums) {
        
        int currFar = 0, currEnd = 0;
        int n = nums.length;
        
        for(int i=0; i<n; i++){
            currFar = Math.max(currFar, nums[i]+i);
            if(currEnd == i){
                currEnd = currFar;
                if(currEnd >= n-1) return true;
            }
        }
        
        return false;
        
    }
}