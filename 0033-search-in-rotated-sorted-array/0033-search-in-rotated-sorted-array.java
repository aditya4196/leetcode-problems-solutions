class Solution {
    public int search(int[] nums, int target) {
        
        int pivot = getPivot(nums, 0, nums.length-1);
        
        if(target == nums[pivot]) return pivot;  
        int result = bsearch(nums, pivot+1, nums.length-1, target);
        
        return (result != -1)?result:bsearch(nums, 0, pivot-1, target);
        
        
        
    }
    
    public int getPivot(int[] nums, int left, int right){
        while(left < right){
            int pivot = left + (right-left)/2;
            if(nums[pivot] > nums[right]){
                left = pivot+1;
            }
            else right = pivot;
        }
        return left;
    }
    
    public int bsearch(int[] nums, int left, int right, int target){
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) right = mid-1;
            else left = mid+1;
        }
        
        return -1;
        
    }
}