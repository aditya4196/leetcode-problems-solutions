class Solution {
    public int jump(int[] nums) {
        
        int currEnd = 0, currFar = 0, result = 0;
        
        for(int i=0; i<nums.length-1; i++){
            currFar = Math.max(currFar, nums[i]+i);
            
            if(i == currEnd){
                System.out.println(currEnd);
                result++;
                currEnd = currFar;
            }
        }
        
        return result;
        
    }
}