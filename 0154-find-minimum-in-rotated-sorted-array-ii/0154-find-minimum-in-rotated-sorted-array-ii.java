class Solution {
    
    int result = Integer.MAX_VALUE;
    public int findMin(int[] nums) {
        binarySearch(nums, 0, nums.length-1);
        return result;
    }
    
    public void binarySearch(int[] nums, int left, int right){
        
        if(left == right){
            result = Math.min(result, nums[left]);
            return;
        }
        
        int mid = left + (right-left)/2;
        
        if(nums[mid] > nums[right]){
            binarySearch(nums, mid+1, right);
        }
        else if(nums[mid] < nums[right]){
            binarySearch(nums, left, mid);
        }
        else{
            binarySearch(nums, mid+1, right);
            binarySearch(nums, left, mid);
        }
        

    }
}

/*

[2,2,3,0,3]
     m
 l
         r
 
 
 

*/