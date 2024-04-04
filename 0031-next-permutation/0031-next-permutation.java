class Solution {
    public void nextPermutation(int[] nums) {
        
        int idx = nums.length-1;
        
        while(idx > 0 && nums[idx] <= nums[idx-1]){
            idx--;
        }
        
        if(idx == 0){
            reverse(nums, 0, nums.length-1);
            return;
        }
        int prev = idx-1;
        
        reverse(nums, idx, nums.length-1);
        
        int nextptr = prev+1;
        while(nextptr < nums.length && nums[nextptr] <= nums[prev]) nextptr++;
        
        swap(nums, nextptr, prev);        
    }
    
    public void reverse(int[] nums, int i, int j){
        while(i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/*

[3,4,5,2,1]
[3,5,1,2,4]






*/