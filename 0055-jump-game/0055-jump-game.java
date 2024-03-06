class Solution {
    public boolean canJump(int[] nums) {
        
        int currEnd = 0, currFarthest = 0;
        if(nums.length == 1) return true;
        
        for(int i=0; i<nums.length; i++){
            currFarthest = Math.max(currFarthest, i+nums[i]);
            
            if(i == currEnd){
                currEnd = currFarthest;
                if(currEnd >= nums.length-1) return true;
            }
        }
        return false;
        
    }
}

/*

2 3 1 1 4
    i
        f
    e





*/