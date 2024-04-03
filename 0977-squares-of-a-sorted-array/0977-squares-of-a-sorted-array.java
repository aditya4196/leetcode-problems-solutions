class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int[] result = new int[nums.length];
        int left = 0, right = nums.length-1;
        int rptr = nums.length-1;
        
        while(left <= right){
            int leftSq = nums[left]*nums[left];
            int rightSq = nums[right]*nums[right];
            
            if(leftSq > rightSq){
                result[rptr--] = leftSq;
                left++;
            }
            else{
                result[rptr--] = rightSq;
                right--;
            }   
        }
        
        return result;
    }
}

/*


[-4,-1,0,3,10]
  i         j
    
 



[0,1,9,16,100]

 




*/