class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        return Math.max(helper(nums, 0, n-2), helper(nums, 1, n-1));
        
    }
    
    public int helper(int[] nums, int start, int end){
        if(start == end) return nums[start];
        if((end-start) == 1) return Math.max(nums[start], nums[end]);
        
        int firstHouse = nums[start];
        int secondHouse = Math.max(nums[start],nums[start+1]);
        int currHouse = 0;
        
        for(int i=start+2; i<=end; i++){
            currHouse = Math.max(nums[i]+firstHouse, secondHouse);
            firstHouse = secondHouse;
            secondHouse = currHouse;
        }
        
        return currHouse;
    }
}