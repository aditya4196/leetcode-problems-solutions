class Solution {
    public int jump(int[] nums) {
        
        int[] minSteps = new int[nums.length];
        int n = nums.length;
        
        Arrays.fill(minSteps, n);
        minSteps[0] = 0;
        
        
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<=Math.min(n-1, nums[i]+i); j++){
                minSteps[j] = Math.min(minSteps[j], 1 + minSteps[i]);
            }
        }
        
        
        return minSteps[n-1];
        
        
        
        
        
    }
}


/*

[2,3,1,1,4]
[0,5,5,5,5]
     
min = i  
      


*/