class Solution {
    public int jump(int[] nums) {
        
        int n = nums.length;
        
        if(n == 1) return 0;
        int minJumps = 0;
        int currEnd = 0, currFarthest = 0;
        
        for(int i=0; i<n; i++){
            currFarthest = Math.max(currFarthest, i + nums[i]);
            if(i == currEnd){
                minJumps++;
                currEnd = currFarthest;
            }
            if(currEnd >= n-1) return minJumps;
        }
        
        return -1;
        
        
        
    }
}

/*

2 3 1 1 4
    i
        f
        e

steps = 1

*/