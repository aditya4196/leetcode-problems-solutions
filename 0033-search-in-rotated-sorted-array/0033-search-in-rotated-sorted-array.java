class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int startIndex = getStartElementIndex(0, n-1, nums);
        
        if(target == nums[startIndex]) return startIndex;
        if(target == nums[n-1]) return n-1;

        if(target > nums[startIndex] && target < nums[n-1]){
            return binarySearch(startIndex, n-1, nums, target);
        }
        else return binarySearch(0, startIndex-1, nums, target);

    }

    public int binarySearch(int left, int right, int[] nums, int target){
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) right = mid-1;
            else left = mid+1;
        }
        return -1;
    }

    public int getStartElementIndex(int left, int right, int[] nums){
        int lastNum = nums[right];
        while(left < right){
            int mid = left + (right-left)/2;
            if(nums[mid] > lastNum) left = mid+1;
            else right = mid;
        }

        return left;
    }
}