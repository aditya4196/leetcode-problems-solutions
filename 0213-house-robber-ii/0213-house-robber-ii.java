class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0],nums[1]); 
        return Math.max(maxStash(nums, 0, n-2), maxStash(nums, 1, n-1));
        
    }
    
    public int maxStash(int[] nums, int start, int end){
        if(end-start <= 1) return Math.max(nums[start],nums[end]);
        
        int firstHouse = nums[start];
        int secondHouse = Math.max(nums[start],nums[start+1]);
        int currHouse = 0;
                                   
        for(int i=start+2; i<=end; i++){
            currHouse = Math.max(firstHouse + nums[i], secondHouse);
            firstHouse = secondHouse;
            secondHouse = currHouse;
        }
                                   
        return currHouse;
        
    }
}