class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = Integer.MAX_VALUE;
        int minSum = Integer.MAX_VALUE;
        
        for(int i=0; i<nums.length; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            
            int j=i+1, k=nums.length-1;
            
            while(j < k){
                int currSum = nums[i] + nums[j] + nums[k];
                if(minSum > Math.abs(currSum - target)){
                    minSum = Math.abs(currSum - target);
                    closestSum = currSum;
                }
                if(currSum > target) k--;
                else j++;
            }
        }
        
        return closestSum;
        
    }
}