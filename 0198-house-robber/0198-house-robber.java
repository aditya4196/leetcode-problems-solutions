class Solution {
    public int rob(int[] nums) {
        int n =nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0],nums[1]);
        
        int firstHouse = nums[0];
        int secondHouse = Math.max(nums[0],nums[1]);
        int currHouse = 0;
        
        for(int i=2; i<n; i++){
            currHouse = Math.max(firstHouse + nums[i], secondHouse);
            firstHouse = secondHouse;
            secondHouse = currHouse;
        }
        
        return currHouse;
        
        
    }
}