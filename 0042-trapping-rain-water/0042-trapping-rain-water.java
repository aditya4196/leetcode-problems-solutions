class Solution {
    public int trap(int[] height) {
        
        int leftMax = 0, rightMax = 0;
        int left = 0, right = height.length-1, waterTrapped = 0;
        
        while(left < right){
            if(height[left] > height[right]){
                if(rightMax <= height[right]) rightMax = height[right];
                else waterTrapped += rightMax - height[right];
                right--;
            }
            else{
                if(leftMax <= height[left]) leftMax = height[left];
                else waterTrapped += leftMax - height[left];
                left++;
            }
            
        }
        
        return waterTrapped;
        
        
        
    }
}

/*

0,1,0,2,1,0,1,3,2,1,2,1
              i
              j
  
watertrapped = 6
leftmax = 2
rightmax = 2



*/