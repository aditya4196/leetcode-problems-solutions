class Solution {
    public int trap(int[] height) {
        
        int left = 0, right = height.length-1;
        int maxLeft = height[left], maxRight = height[right];
        int waterTrapped = 0;
        
        while(left < right){
            if(height[left] <= height[right]){
                if(maxLeft < height[left]) maxLeft = height[left];
                else waterTrapped += (maxLeft - height[left]);
                left++;
            }   
            else{
                if(maxRight < height[right]) maxRight = height[right];
                else waterTrapped += (maxRight - height[right]);
                right--;
            }
        }
        
        return waterTrapped;
        
        
        
        
    }
}