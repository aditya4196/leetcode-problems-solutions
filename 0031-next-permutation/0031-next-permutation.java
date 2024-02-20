class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = n-2;
        
        while(pivot >= 0 && nums[pivot] >= nums[pivot+1]) pivot--;
        
        if(pivot == -1){
            reverse(nums,0,n-1);
        }
        else{
          reverse(nums, pivot+1, n-1);
          int j = pivot+1;
          while(j<n && nums[j] <= nums[pivot]) j++;
          swap(nums, pivot, j);
        }
        
        
        
    }
    
    public void reverse(int[] nums, int i, int j){
        while(i < j){
            swap(nums, i++, j--);
        }
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/*


1 2 5 4 3 0 



*/