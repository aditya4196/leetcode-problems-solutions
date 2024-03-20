class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         
        int x = nums1.length, y = nums2.length;
        if(x > y) return findMedianSortedArrays(nums2, nums1);
        
        boolean isEvenLength = ((x+y)%2 == 0);
        int left = 0, right = x;
        
        while(left <= right){
            int partX = left + (right-left)/2;
            int partY = (x + y + 1)/2 - partX;
            
            int minLeftX = (partX == 0)?(Integer.MIN_VALUE):(nums1[partX-1]);
            int minLeftY = (partY == 0)?(Integer.MIN_VALUE):(nums2[partY-1]);
            int maxRightX = (partX == x)?(Integer.MAX_VALUE):(nums1[partX]);
            int maxRightY = (partY == y)?(Integer.MAX_VALUE):(nums2[partY]);
            
            if(minLeftX <= maxRightY && minLeftY <= maxRightX){
                if(isEvenLength) return (double)(Math.min(maxRightX, maxRightY) + Math.max(minLeftX, minLeftY))/2;
                else return (double)(Math.max(minLeftX, minLeftY));
            }
            
            if(minLeftX > maxRightY){
                right = partX-1;
            }
            else if(minLeftY > maxRightX){
                left = partX+1;
            }
        }
        
        return -1.0;
    }
}

/*

[1,3]
[2,4,5]
 0 1
[1,3] y = 2
 m
 
 left + (right-left)/2
 
 partitiony = 1
 
 partitionx = (3 - 1) = 2
 

[2,4,5] x = 3

total = 5

[3]
 x
   
[2,4,5]
       y
     
[-1,0 |6]
[1  | 2]



*/