class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        if(nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        
        int x = nums1.length;
        int y = nums2.length;
        
        boolean isEvenLength = (x+y)%2 == 0;
        
        int maxLeftX = 0, minRightX = 0, maxLeftY = 0, minRightY = 0;
        int left = 0, right = x;
        
        while(left <= right){
            int partitionX = left + (right-left)/2;
            int partitionY = (x+y+1)/2 - partitionX;
            
            maxLeftX = (partitionX == 0)?(Integer.MIN_VALUE):(nums1[partitionX-1]);
            maxLeftY = (partitionY == 0)?(Integer.MIN_VALUE):(nums2[partitionY-1]);
            minRightX = (partitionX == x)?(Integer.MAX_VALUE):(nums1[partitionX]);
            minRightY = (partitionY == y)?(Integer.MAX_VALUE):(nums2[partitionY]);
            
            if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                if(isEvenLength){
                    return ((double)Math.max(maxLeftX, maxLeftY) + (double)Math.min(minRightX, minRightY)) / 2;
                }
                else{
                    return Math.max(maxLeftX, maxLeftY);
                }
            }
            else if(maxLeftX > minRightY){
                right = partitionX-1;
            }
            else{
                left = partitionX+1;
            }
        }
        
        return -1.0;
        
        
    }
}