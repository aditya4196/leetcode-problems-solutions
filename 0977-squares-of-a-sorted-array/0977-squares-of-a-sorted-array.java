class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        int i=0, j=n-1;
        
        for(int k=n-1; k>=0; k--){
            if(nums[i]*nums[i] >= nums[j]*nums[j]){
                result[k] = nums[i]*nums[i];
                i++;
            }
            else{
                result[k] = nums[j]*nums[j];
                j--;
            }
        }
        
        return result;
        
        
        
    }
}



/*


[-4, -1, 0, 3, 10]
      i
            j

[0, 0, 0, 16, 100]



*/