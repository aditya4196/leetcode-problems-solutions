class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int maxArea = 0;
        int i=0, j=n-1;
        
        while(i < j){
            int width = j-i;
            maxArea = Math.max(maxArea, Math.min(height[i], height[j])*width);
            if(height[i] > height[j]) j--;
            else i++;
        }
        
        return maxArea;
        
    }
}