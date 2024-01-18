class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        left[0] = height[0];
        
        for(int i=1; i<n; i++){
            left[i] = Math.max(left[i-1], height[i]);
        }
        
        int maxRightHeight = height[n-1];
        int result = 0;
        
        for(int i=n-1; i>=0; i--){
            maxRightHeight = Math.max(maxRightHeight, height[i]);
            result += Math.min(maxRightHeight, left[i]) - height[i];
        }
        
        return result;
    
        
        
        
    }
}