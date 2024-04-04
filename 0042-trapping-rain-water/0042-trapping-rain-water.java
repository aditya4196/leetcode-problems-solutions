class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int maxLeft = height[0];
        
        for(int i=0; i<n; i++){
            maxLeft = Math.max(maxLeft, height[i]);
            leftMax[i] = maxLeft;
        }
        
        int rightMax = height[n-1];
        int waterTrapped = 0;
        
        for(int i=n-1; i>=0; i--){
            rightMax = Math.max(rightMax, height[i]);
            waterTrapped += Math.max(Math.min(leftMax[i], rightMax) - height[i], 0);    
        }
        
        return waterTrapped;
        
        
        
        
    }
}