class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int i=0, j=n-1;
        int pivot = 0;
        
        while(pivot <= j){
            if(nums[pivot] == 0) swap(nums, pivot++, i++);
            else if(nums[pivot] == 2) swap(nums, pivot, j--);
            else{
                pivot++;
            }
        }  
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/*

 [0,1,2]
    i
      j
      
      p





*/