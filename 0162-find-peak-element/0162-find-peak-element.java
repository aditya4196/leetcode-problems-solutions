class Solution {
    public int findPeakElement(int[] nums) {
        
        int left = 0, right = nums.length-1;
        
        while(left < right){
            int mid = left + (right-left)/2;
            
            if(mid < nums.length-1 && nums[mid] > nums[mid+1]) right = mid;
            else left = mid+1;
        }
        
        return left;
        
    }
}

/*

1,2,1,3,5,6,4
        m
          i
          j


*/