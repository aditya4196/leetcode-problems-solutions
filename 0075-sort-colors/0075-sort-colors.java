class Solution {
    public void sortColors(int[] nums) {
        
        int lptr = 0, rptr = nums.length-1, pivot = 0;
        
        while(pivot <= rptr){
            if(nums[pivot] == 0){
                swap(nums, pivot, lptr);
                pivot++;
                lptr++;
            }
            else if(nums[pivot] == 2){
                swap(nums, pivot, rptr);
                rptr--;
            }
            else pivot++;
        }
        
        
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/*

[0,0,0,1,2,2]
     i
         j
       p




*/