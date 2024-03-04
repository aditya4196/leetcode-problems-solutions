class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] reachable = new boolean[n];
        reachable[n-1] = true;
        
        for(int i=n-2; i>=0; i--){
            for(int j=i+1; j<=Math.min(i+nums[i], n-1); j++){
                if(reachable[j]){
                    reachable[i] = true;
                    break;
                }
            }
        }
        
        return reachable[0];
        
        
    }
}

/*

[2,3,1,1,4]
   T T T T
   i
  


*/