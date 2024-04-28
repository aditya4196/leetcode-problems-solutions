class Solution {
    public void moveZeroes(int[] nums) {
        
        int zeroptr = 0;
        for(int curr=0; curr<nums.length; curr++){
            if(nums[curr] != 0){
                swap(nums, zeroptr++, curr);
            }
        }
        
        
    }
    
    public void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}

/*

[1,2,0,3,12]
 i
 j



*/